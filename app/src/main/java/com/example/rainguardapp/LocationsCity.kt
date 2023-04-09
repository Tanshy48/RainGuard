package com.example.rainguardapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class LocationsCity:AppCompatActivity() {
    val citiesCrimea = arrayOf("Сімферополь", "Ялта", "Севастополь", "Алушта", "Феодосія", "Керч", "Євпаторія", "Джанкой", "Саки", "Красноперекопськ", "Армянськ", "Щолкіне", "Бахчисарай", "Щастя", "Новоозерне", "Старий Крим", "Інкерман")
    val citiesVinnytsia = arrayOf("Вінниця", "Хмільник", "Могилів-Подільський", "Козятин", "Жмеринка", "Ладижин", "Гайсин", "Тульчин", "Немирів", "Крижопіль", "Бар", "Гнівань", "Іллінці", "Літин")
    val citiesVolyn = arrayOf("Луцьк", "Ковель", "Нововолинськ", "Камінь-Каширський", "Володимир-Волинський", "Любомль", "Рожище", "Шацьк", "Ківерці", "Верхівцеве", "Красноград", "Маневичі", "Турійськ", "Іваничі")
    val citiesDnipro = arrayOf("Дніпро", "Кривий Ріг", "Нікополь", "Павлоград", "Кам'янське", "Марганець", "Верхівцеве", "Дніпровськ", "Новомосковськ", "Жовті Води", "Перещепине", "П'ятихатки", "Синельникове", "Тернівка", "Апостолове", "Вільногірськ", "Дніпрорудне", "Іллічівськ")
    val citiesDonetsk = arrayOf("Донецьк", "Макіївка", "Маріуполь", "Харцизьк", "Горлівка", "Краматорськ", "Слов'янськ", "Авдіївка", "Єнакієве", "Дебальцеве", "Торез", "Красноармійськ", "Константинівка", "Світлодарськ", "Дружківка", "Артемівськ", "Новогродівка", "Волноваха", "Селидове", "Торецьк", "Амвросіївка", "Вуглегірськ", "Харцизьк", "Іловайськ")
    val citiesZhytomyr = arrayOf("Житомир", "Бердичів", "Коростень", "Новоград-Волинський", "Малин", "Овруч", "Хорошів", "Радомишль", "Чуднів", "Іршанськ", "Коростишів", "Народичі", "Емілчине", "Брусилів", "Червоноармійськ", "Пулини", "Романівка")
    val citiesZakarpattia = arrayOf("Ужгород", "Мукачево", "Хуст", "Виноградів", "Свалява", "Тячів", "Перечин", "Рахів", "Іршава", "Солотвино", "Берегове", "Воловець", "Міжгір'я")
    val citiesZaporizhzhia = arrayOf("Запоріжжя", "Мелітополь", "Бердянськ", "Енергодар", "Василівка", "Кам'янка-Дніпровська", "Токмак", "Оріхів", "Пологи", "Молочанськ", "Приморськ", "Розівка", "Білозір'є")
    val citiesIvanoFrankivsk = arrayOf("Івано-Франківськ", "Калуш", "Коломия", "Богородчани", "Болехів", "Бурштин", "Галич", "Городенка", "Долина", "Косів", "Надвірна", "Рогатин", "Снятин", "Тисмениця", "Яремче")
    val citiesKyiv = arrayOf("Київ", "Бровари", "Вишгород", "Боярка", "Буча", "Ірпінь", "Обухів", "Тараща", "Фастів", "Васильків", "Переяслав-Хмельницький", "Баришівка", "Бориспіль", "Володарка", "Гостомель", "Згурівка", "Макарів", "Миронівка", "Першотравенськ", "Ржищів", "Сквира", "Ставище", "Тетіїв", "Узин", "Яготин")
    val citiesKirovohrad = arrayOf("Кропивницький", "Олександрія", "Світловодськ", "Знам'янка", "Долинська", "Новоукраїнка", "Новомиргород", "Гайворон", "Бобринець", "Мала Виска", "Олександрівка", "Помічна", "Синельникове", "Ульянове", "Єлизаветград")
    val citiesLuhansk = arrayOf("Лисичанськ", "Луганськ", "Алчевськ", "Антрацит", "Біловодськ", "Білогірськ", "Кадіївка", "Краснодон", "Красний Луч", "Первомайськ", "Ровеньки", "Сєвєродонецьк", "Сорокине", "Старобільськ", "Суходільськ", "Щастя")
    val citiesLviv = arrayOf("Львів", "Дрогобич", "Самбір", "Стрий", "Червоноград", "Жовква", "Борислав", "Новий Розділ", "Сокаль", "Трускавець", "Стебник", "Броди", "Перемишляни", "Турка", "Миколаїв", "Городок", "Хирів", "Рудки", "Сколе", "Яворів", "Перемишль")
    val citiesMykolaiv = arrayOf("Миколаїв", "Первомайськ", "Нова Одеса", "Вознесенськ", "Южноукраїнськ", "Снігурівка", "Новий Буг", "Баштанка", "Очаків", "Березнегувате", "Криве Озеро", "Врадіївка", "Доманівка", "Казанка", "Миколаївка", "Нові Білозерки", "Олександрівка", "Ольшанка", "Славське", "Терезівка", "Чорноморськ")
    val citiesOdessa = arrayOf("Одеса", "Ізмаїл", "Южне", "Миколаївка", "Рені", "Березівка", "Біляївка", "Вилкове", "Жовті Води", "Кілія", "Кодима", "Комінтернівське", "Котовськ", "Красні Окни", "Маяк", "Подільськ", "Роздільна", "Саврань", "Тарутине", "Татарбунари", "Фрунзівка", "Чорноморськ", "Балта", "Білгород-Дністровський", "Велика Михайлівка", "Іллічівськ", "Комінтернівське", "Красилів", "Любашівка", "Могилів-Подільський", "Розсошенці", "Теплодар", "Тячівка")
    val citiesPoltava = arrayOf("Полтава", "Кременчук", "Миргород", "Гадяч", "Лубни", "Кобеляки", "Карлівка", "Глобине", "Нові Санжари", "Хорол", "Зіньків", "Пирятин", "Оржиця", "Великі Сорочинці", "Гребінка", "Лохвиця", "Решетилівка", "Котельва", "Комсомольськ", "Семенівка", "Градизьк", "Білики", "Машівка", "Нова Галещина", "Ворожба", "Заводське", "Козельщина", "Котельвщина", "Лисянка", "Мала Перещепина", "Миропіль", "Розсоша", "Чутове")
    val citiesRivne = arrayOf("Рівне", "Дубно", "Сарни", "Кузнецовськ", "Костопіль", "Здолбунів", "Березне", "Остріг", "Гоща", "Вараш", "Світанок", "Червоноармійськ", "Бронне", "Зарічне", "Клесів", "Корець", "Млинів", "Поворинь", "Рокитне", "Рось", "Рубежне", "Турійськ", "Червона Калина", "Щорс")
    val citiesSumy = arrayOf("Суми", "Конотоп", "Шостка", "Охтирка", "Ромни", "Глухів", "Лебедин", "Білопілля", "Краснопілля", "Буринь", "Тростянець", "Середина-Буда", "Путивль", "Хорол", "Гадяч", "Бежанці", "Велика Писарівка", "Богодухів", "Козача Лопань", "Недригайлів", "Недригайлів", "Орілька", "Петрівка", "Полтавка", "Роздільна", "Савинці", "Солоницівка", "Терещівка", "Тростянець", "Угроїди", "Фастівцеве", "Хирівка", "Чернухи")
    val citiesTernopil = arrayOf("Тернопіль", "Чортків", "Кременець", "Бережани", "Збараж", "Теребовля", "Підволочиськ", "Ланівці", "Гусятин", "Борщів", "Заліщики", "Зборів", "Козова", "Копичинці", "Монастириська", "Подібці", "Скалат", "Чорнотисова", "Шумськ", "Зарваниця", "Великі Бірки", "Городенка", "Залізці", "Збараж", "Копичинці", "Кременець", "Кривче", "Ліщинці", "Монастириська", "Новосілки", "Почаїв", "Скалат", "Стебник", "Ступки", "Теребовля", "Товсте", "Тростянець", "Чорнотисова")
    val citiesKharkiv = arrayOf("Харків", "Ізюм", "Лозова", "Чугуїв", "Первомайський", "Куп'янськ", "Дергачі", "Балаклія", "Вовчанськ", "Красноград", "Комсомольськ", "Мерефа", "Нововодолазький", "Південний", "Покотилівка", "Богодухів", "Борівський", "Валки", "Дворічна", "Зачепилівка", "Зміїв", "Коротич", "Краснокутськ", "Краснопавлівка", "Куп'янське", "Люботин", "Мала Данилівка", "Нова Водолага", "Первомайський", "Петровське", "Сахновщина", "Сіверськ", "Чугуївський", "Шевченківський")
    val citiesKherson = arrayOf("Херсон", "Нова Каховка", "Каховка", "Скадовськ", "Цюрупинськ", "Берислав", "Генічеськ", "Гола Пристань", "Кам'янка-Дніпровська", "Каховський", "Нижньосірогозький", "Новотроїцьке", "Олешківський", "Скадовський", "Таврійськ", "Великоолександрівський", "Високопільський", "Великоолександрівський", "Голопристанський", "Каховський", "Нижньосірогозький", "Новотроїцький", "Олешківський", "Скадовський", "Таврійський")
    val citiesCherkasy = arrayOf("Черкаси", "Умань", "Золотоноша", "Сміла", "Канів", "Корсунь-Шевченківський", "Жашків", "Кам'янка", "Тальне", "Шпола", "Катеринопіль", "Чигирин", "Звенигородка", "Ватутіне", "Крижопіль", "Канівський", "Монастирищенський", "Смілянський", "Уманський", "Христинівський", "Черкаський", "Катеринопільський", "Чигиринський", "Шполянський")
    val citiesChernivtsi = arrayOf("Чернівці", "Новоселиця", "Сторожинець", "Кіцмань", "Вашківці", "Заставна", "Кельменці", "Сокиряни", "Путила", "Хотин", "Герца", "Сторожинецький", "Новоселицький", "Кельменецький", "Путильський", "Сокирянський", "Хотинський")
    val citiesChernihiv = arrayOf("Чернігів", "Ніжин", "Прилуки", "Сновськ", "Ічня", "Мена", "Бахмач", "Новгород-Сіверський", "Козелець", "Седнів", "Корюківка", "Бобровиця", "Сосниця", "Ніжинський", "Прилуцький", "Ічнянський", "Менський", "Новгород-Сіверський район", "Сосницький")
    val citiesKhmelnytsk = arrayOf("Хмельницький", "Кам'янець-Подільський", "Старокостянтинів", "Красилів", "Деражня", "Нетішин", "Полонне", "Ізяслав", "Славута", "Шепетівка")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(com.example.rainguardapp.R.layout.locations_city)
        val spinner = findViewById<Spinner>(com.example.rainguardapp.R.id.spinner1)
        val value = intent.getStringExtra("key")
        when (value) {
            "Автономна Республіка Крим" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesCrimea)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Вінницька" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesVinnytsia)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Волинська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesVolyn)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Дніпропетровська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesDnipro)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Донецька" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesDonetsk)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Житомирська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesZhytomyr)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Закарпатська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesZakarpattia)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Запорізька" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesZaporizhzhia)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Івано-Франківська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesIvanoFrankivsk)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Київська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesKyiv)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Кіровоградська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesKirovohrad)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Луганська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesLuhansk)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Львівська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesLviv)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }"Миколаївська" -> {
            val adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesMykolaiv)
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.setAdapter(adapter)
        }"Одеська" -> {
            val adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesOdessa)
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.setAdapter(adapter)
        }
            "Полтавська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesPoltava)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Рівненська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesRivne)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Сумська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesSumy)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Тернопільська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesTernopil)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Харківська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesKharkiv)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Херсонська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesKherson)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Хмельницька" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesKhmelnytsk)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Черкаська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesCherkasy)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Чернівецька" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesChernivtsi)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
            "Чернігівська" -> {
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.simple_spinner_item, citiesChernihiv)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinner.setAdapter(adapter)
            }
        }
    }
        fun Back(view: View) {
            val intent = Intent(this@LocationsCity, LocationsOB::class.java)
            startActivity(intent)
        }


    }