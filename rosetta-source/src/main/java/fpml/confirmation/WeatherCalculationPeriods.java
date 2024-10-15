package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.WeatherCalculationPeriod;
import fpml.confirmation.WeatherCalculationPeriods;
import fpml.confirmation.WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder;
import fpml.confirmation.WeatherCalculationPeriods.WeatherCalculationPeriodsBuilderImpl;
import fpml.confirmation.WeatherCalculationPeriods.WeatherCalculationPeriodsImpl;
import fpml.confirmation.meta.WeatherCalculationPeriodsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The schedule of Calculation Period First Days and Lasts Days. If there is only one First Day - Last Day pair then the First is equal to the Effective Date and the Last Day is equal to the Termination Date.
 * @version ${project.version}
 */
@RosettaDataType(value="WeatherCalculationPeriods", builder=WeatherCalculationPeriods.WeatherCalculationPeriodsBuilderImpl.class, version="${project.version}")
public interface WeatherCalculationPeriods extends RosettaModelObject {

	WeatherCalculationPeriodsMeta metaData = new WeatherCalculationPeriodsMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends WeatherCalculationPeriod> getCalculationPeriod();
	String getId();

	/*********************** Build Methods  ***********************/
	WeatherCalculationPeriods build();
	
	WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder toBuilder();
	
	static WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder builder() {
		return new WeatherCalculationPeriods.WeatherCalculationPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherCalculationPeriods> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherCalculationPeriods> getType() {
		return WeatherCalculationPeriods.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriod"), processor, WeatherCalculationPeriod.class, getCalculationPeriod());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherCalculationPeriodsBuilder extends WeatherCalculationPeriods, RosettaModelObjectBuilder {
		WeatherCalculationPeriod.WeatherCalculationPeriodBuilder getOrCreateCalculationPeriod(int _index);
		List<? extends WeatherCalculationPeriod.WeatherCalculationPeriodBuilder> getCalculationPeriod();
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(WeatherCalculationPeriod calculationPeriod0);
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(WeatherCalculationPeriod calculationPeriod1, int _idx);
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(List<? extends WeatherCalculationPeriod> calculationPeriod2);
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder setCalculationPeriod(List<? extends WeatherCalculationPeriod> calculationPeriod3);
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriod"), processor, WeatherCalculationPeriod.WeatherCalculationPeriodBuilder.class, getCalculationPeriod());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherCalculationPeriods  ***********************/
	class WeatherCalculationPeriodsImpl implements WeatherCalculationPeriods {
		private final List<? extends WeatherCalculationPeriod> calculationPeriod;
		private final String id;
		
		protected WeatherCalculationPeriodsImpl(WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder builder) {
			this.calculationPeriod = ofNullable(builder.getCalculationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		public List<? extends WeatherCalculationPeriod> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public WeatherCalculationPeriods build() {
			return this;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder toBuilder() {
			WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder builder) {
			ofNullable(getCalculationPeriod()).ifPresent(builder::setCalculationPeriod);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherCalculationPeriods _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherCalculationPeriods {" +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherCalculationPeriods  ***********************/
	class WeatherCalculationPeriodsBuilderImpl implements WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder {
	
		protected List<WeatherCalculationPeriod.WeatherCalculationPeriodBuilder> calculationPeriod = new ArrayList<>();
		protected String id;
	
		public WeatherCalculationPeriodsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationPeriod")
		public List<? extends WeatherCalculationPeriod.WeatherCalculationPeriodBuilder> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		public WeatherCalculationPeriod.WeatherCalculationPeriodBuilder getOrCreateCalculationPeriod(int _index) {
		
			if (calculationPeriod==null) {
				this.calculationPeriod = new ArrayList<>();
			}
			WeatherCalculationPeriod.WeatherCalculationPeriodBuilder result;
			return getIndex(calculationPeriod, _index, () -> {
						WeatherCalculationPeriod.WeatherCalculationPeriodBuilder newCalculationPeriod = WeatherCalculationPeriod.builder();
						return newCalculationPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(WeatherCalculationPeriod calculationPeriod) {
			if (calculationPeriod!=null) this.calculationPeriod.add(calculationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(WeatherCalculationPeriod calculationPeriod, int _idx) {
			getIndex(this.calculationPeriod, _idx, () -> calculationPeriod.toBuilder());
			return this;
		}
		@Override 
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(List<? extends WeatherCalculationPeriod> calculationPeriods) {
			if (calculationPeriods != null) {
				for (WeatherCalculationPeriod toAdd : calculationPeriods) {
					this.calculationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("calculationPeriod")
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder setCalculationPeriod(List<? extends WeatherCalculationPeriod> calculationPeriods) {
			if (calculationPeriods == null)  {
				this.calculationPeriod = new ArrayList<>();
			}
			else {
				this.calculationPeriod = calculationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public WeatherCalculationPeriods build() {
			return new WeatherCalculationPeriods.WeatherCalculationPeriodsImpl(this);
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder prune() {
			calculationPeriod = calculationPeriod.stream().filter(b->b!=null).<WeatherCalculationPeriod.WeatherCalculationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriod()!=null && getCalculationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder o = (WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriod(), o.getCalculationPeriod(), this::getOrCreateCalculationPeriod);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherCalculationPeriods _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherCalculationPeriodsBuilder {" +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
