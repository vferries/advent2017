package en.veille.day1

class Day20 {
    companion object {
        fun findClosestToOrigin(text: String): Int {
            val particles = parseParticles(text)
            return particles.indexOfFirst { it.acceleration == Pos3D(0, 0, 0) }
        }

        fun remainingParticlesAfter(text: String, iterations: Int): Int {
            var particles = parseParticles(text)
            for (i in 0 until iterations) {
                particles = particles.removeCollisions()
                particles = particles.map(Particle::move)
            }
            println(particles)
            return particles.size
        }

        private fun parseParticles(text: String): List<Particle> {
            val regex =
                """p=<(-?\d+),(-?\d+),(-?\d+)>, v=<(-?\d+),(-?\d+),(-?\d+)>, a=<(-?\d+),(-?\d+),(-?\d+)>""".toRegex()
            return text.lines().map { line ->
                val nums = regex.find(line)?.groupValues!!.drop(1).map(String::toInt)
                Particle(
                    Pos3D(nums[0], nums[1], nums[2]),
                    Pos3D(nums[3], nums[4], nums[5]),
                    Pos3D(nums[6], nums[7], nums[8])
                )
            }
        }
    }

    data class Particle(val pos: Pos3D, val speed: Pos3D, val acceleration: Pos3D) {
        fun move(): Particle {
            val velocity = speed + acceleration
            return Particle(pos + velocity, velocity, acceleration)
        }
    }

    data class Pos3D(val x: Int, val y: Int, val z: Int) {
        operator fun plus(other: Pos3D): Pos3D {
            return Pos3D(x + other.x, y + other.y, z + other.z)
        }
    }
}

private fun List<Day20.Particle>.removeCollisions(): List<Day20.Particle> {
    val counts = this.groupingBy { it.pos }.eachCount()
    return this.filter { counts[it.pos] == 1 }
}
