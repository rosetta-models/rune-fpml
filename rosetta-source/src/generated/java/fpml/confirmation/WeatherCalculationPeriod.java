package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.WeatherCalculationPeriod;
import fpml.confirmation.WeatherCalculationPeriod.WeatherCalculationPeriodBuilder;
import fpml.confirmation.WeatherCalculationPeriod.WeatherCalculationPeriodBuilderImpl;
import fpml.confirmation.WeatherCalculationPeriod.WeatherCalculationPeriodImpl;
import fpml.confirmation.meta.WeatherCalculationPeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The schedule of Calculation Period First Days and Lasts Days. If there is only one First Day - Last Day pair then the First is equal to the Effective Date and the Last Day is equal to the Termination Date.
 * @version ${project.version}
 */
@RosettaDataType(value="WeatherCalculationPeriod", builder=WeatherCalculationPeriod.WeatherCalculationPeriodBuilderImpl.class, version="${project.version}")
public interface WeatherCalculationPeriod extends RosettaModelObject {

	WeatherCalculationPeriodMeta metaData = new WeatherCalculationPeriodMeta();

	/*********************** Getter Methods  ***********************/
	IdentifiedDate getCalculationPeriodFirstDay();
	IdentifiedDate getCalculationPeriodEndDay();

	/*********************** Build Methods  ***********************/
	WeatherCalculationPeriod build();
	
	WeatherCalculationPeriod.WeatherCalculationPeriodBuilder toBuilder();
	
	static WeatherCalculationPeriod.WeatherCalculationPeriodBuilder builder() {
		return new WeatherCalculationPeriod.WeatherCalculationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherCalculationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherCalculationPeriod> getType() {
		return WeatherCalculationPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriodFirstDay"), processor, IdentifiedDate.class, getCalculationPeriodFirstDay());
		processRosetta(path.newSubPath("calculationPeriodEndDay"), processor, IdentifiedDate.class, getCalculationPeriodEndDay());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherCalculationPeriodBuilder extends WeatherCalculationPeriod, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateCalculationPeriodFirstDay();
		IdentifiedDate.IdentifiedDateBuilder getCalculationPeriodFirstDay();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateCalculationPeriodEndDay();
		IdentifiedDate.IdentifiedDateBuilder getCalculationPeriodEndDay();
		WeatherCalculationPeriod.WeatherCalculationPeriodBuilder setCalculationPeriodFirstDay(IdentifiedDate calculationPeriodFirstDay);
		WeatherCalculationPeriod.WeatherCalculationPeriodBuilder setCalculationPeriodEndDay(IdentifiedDate calculationPeriodEndDay);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriodFirstDay"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getCalculationPeriodFirstDay());
			processRosetta(path.newSubPath("calculationPeriodEndDay"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getCalculationPeriodEndDay());
		}
		

		WeatherCalculationPeriod.WeatherCalculationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherCalculationPeriod  ***********************/
	class WeatherCalculationPeriodImpl implements WeatherCalculationPeriod {
		private final IdentifiedDate calculationPeriodFirstDay;
		private final IdentifiedDate calculationPeriodEndDay;
		
		protected WeatherCalculationPeriodImpl(WeatherCalculationPeriod.WeatherCalculationPeriodBuilder builder) {
			this.calculationPeriodFirstDay = ofNullable(builder.getCalculationPeriodFirstDay()).map(f->f.build()).orElse(null);
			this.calculationPeriodEndDay = ofNullable(builder.getCalculationPeriodEndDay()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFirstDay")
		public IdentifiedDate getCalculationPeriodFirstDay() {
			return calculationPeriodFirstDay;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodEndDay")
		public IdentifiedDate getCalculationPeriodEndDay() {
			return calculationPeriodEndDay;
		}
		
		@Override
		public WeatherCalculationPeriod build() {
			return this;
		}
		
		@Override
		public WeatherCalculationPeriod.WeatherCalculationPeriodBuilder toBuilder() {
			WeatherCalculationPeriod.WeatherCalculationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherCalculationPeriod.WeatherCalculationPeriodBuilder builder) {
			ofNullable(getCalculationPeriodFirstDay()).ifPresent(builder::setCalculationPeriodFirstDay);
			ofNullable(getCalculationPeriodEndDay()).ifPresent(builder::setCalculationPeriodEndDay);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodFirstDay, _that.getCalculationPeriodFirstDay())) return false;
			if (!Objects.equals(calculationPeriodEndDay, _that.getCalculationPeriodEndDay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodFirstDay != null ? calculationPeriodFirstDay.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodEndDay != null ? calculationPeriodEndDay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherCalculationPeriod {" +
				"calculationPeriodFirstDay=" + this.calculationPeriodFirstDay + ", " +
				"calculationPeriodEndDay=" + this.calculationPeriodEndDay +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherCalculationPeriod  ***********************/
	class WeatherCalculationPeriodBuilderImpl implements WeatherCalculationPeriod.WeatherCalculationPeriodBuilder {
	
		protected IdentifiedDate.IdentifiedDateBuilder calculationPeriodFirstDay;
		protected IdentifiedDate.IdentifiedDateBuilder calculationPeriodEndDay;
	
		public WeatherCalculationPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationPeriodFirstDay")
		public IdentifiedDate.IdentifiedDateBuilder getCalculationPeriodFirstDay() {
			return calculationPeriodFirstDay;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateCalculationPeriodFirstDay() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (calculationPeriodFirstDay!=null) {
				result = calculationPeriodFirstDay;
			}
			else {
				result = calculationPeriodFirstDay = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodEndDay")
		public IdentifiedDate.IdentifiedDateBuilder getCalculationPeriodEndDay() {
			return calculationPeriodEndDay;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateCalculationPeriodEndDay() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (calculationPeriodEndDay!=null) {
				result = calculationPeriodEndDay;
			}
			else {
				result = calculationPeriodEndDay = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFirstDay")
		public WeatherCalculationPeriod.WeatherCalculationPeriodBuilder setCalculationPeriodFirstDay(IdentifiedDate calculationPeriodFirstDay) {
			this.calculationPeriodFirstDay = calculationPeriodFirstDay==null?null:calculationPeriodFirstDay.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodEndDay")
		public WeatherCalculationPeriod.WeatherCalculationPeriodBuilder setCalculationPeriodEndDay(IdentifiedDate calculationPeriodEndDay) {
			this.calculationPeriodEndDay = calculationPeriodEndDay==null?null:calculationPeriodEndDay.toBuilder();
			return this;
		}
		
		@Override
		public WeatherCalculationPeriod build() {
			return new WeatherCalculationPeriod.WeatherCalculationPeriodImpl(this);
		}
		
		@Override
		public WeatherCalculationPeriod.WeatherCalculationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherCalculationPeriod.WeatherCalculationPeriodBuilder prune() {
			if (calculationPeriodFirstDay!=null && !calculationPeriodFirstDay.prune().hasData()) calculationPeriodFirstDay = null;
			if (calculationPeriodEndDay!=null && !calculationPeriodEndDay.prune().hasData()) calculationPeriodEndDay = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodFirstDay()!=null && getCalculationPeriodFirstDay().hasData()) return true;
			if (getCalculationPeriodEndDay()!=null && getCalculationPeriodEndDay().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherCalculationPeriod.WeatherCalculationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherCalculationPeriod.WeatherCalculationPeriodBuilder o = (WeatherCalculationPeriod.WeatherCalculationPeriodBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodFirstDay(), o.getCalculationPeriodFirstDay(), this::setCalculationPeriodFirstDay);
			merger.mergeRosetta(getCalculationPeriodEndDay(), o.getCalculationPeriodEndDay(), this::setCalculationPeriodEndDay);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodFirstDay, _that.getCalculationPeriodFirstDay())) return false;
			if (!Objects.equals(calculationPeriodEndDay, _that.getCalculationPeriodEndDay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodFirstDay != null ? calculationPeriodFirstDay.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodEndDay != null ? calculationPeriodEndDay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherCalculationPeriodBuilder {" +
				"calculationPeriodFirstDay=" + this.calculationPeriodFirstDay + ", " +
				"calculationPeriodEndDay=" + this.calculationPeriodEndDay +
			'}';
		}
	}
}
