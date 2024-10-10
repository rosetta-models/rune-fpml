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
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.WeatherCalculationPeriodModel;
import fpml.confirmation.WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder;
import fpml.confirmation.WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilderImpl;
import fpml.confirmation.WeatherCalculationPeriodModel.WeatherCalculationPeriodModelImpl;
import fpml.confirmation.WeatherCalculationPeriods;
import fpml.confirmation.meta.WeatherCalculationPeriodModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Descriptions of a calculation period.
 * @version ${project.version}
 */
@RosettaDataType(value="WeatherCalculationPeriodModel", builder=WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilderImpl.class, version="${project.version}")
public interface WeatherCalculationPeriodModel extends RosettaModelObject {

	WeatherCalculationPeriodModelMeta metaData = new WeatherCalculationPeriodModelMeta();

	/*********************** Getter Methods  ***********************/
	WeatherCalculationPeriods getWeatherCalculationPeriods();
	CalculationPeriodsReference getWeatherCalculationPeriodsReference();

	/*********************** Build Methods  ***********************/
	WeatherCalculationPeriodModel build();
	
	WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder toBuilder();
	
	static WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder builder() {
		return new WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherCalculationPeriodModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeatherCalculationPeriodModel> getType() {
		return WeatherCalculationPeriodModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("weatherCalculationPeriods"), processor, WeatherCalculationPeriods.class, getWeatherCalculationPeriods());
		processRosetta(path.newSubPath("weatherCalculationPeriodsReference"), processor, CalculationPeriodsReference.class, getWeatherCalculationPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherCalculationPeriodModelBuilder extends WeatherCalculationPeriodModel, RosettaModelObjectBuilder {
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getOrCreateWeatherCalculationPeriods();
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getWeatherCalculationPeriods();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateWeatherCalculationPeriodsReference();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getWeatherCalculationPeriodsReference();
		WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder setWeatherCalculationPeriods(WeatherCalculationPeriods weatherCalculationPeriods);
		WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder setWeatherCalculationPeriodsReference(CalculationPeriodsReference weatherCalculationPeriodsReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("weatherCalculationPeriods"), processor, WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder.class, getWeatherCalculationPeriods());
			processRosetta(path.newSubPath("weatherCalculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getWeatherCalculationPeriodsReference());
		}
		

		WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherCalculationPeriodModel  ***********************/
	class WeatherCalculationPeriodModelImpl implements WeatherCalculationPeriodModel {
		private final WeatherCalculationPeriods weatherCalculationPeriods;
		private final CalculationPeriodsReference weatherCalculationPeriodsReference;
		
		protected WeatherCalculationPeriodModelImpl(WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder builder) {
			this.weatherCalculationPeriods = ofNullable(builder.getWeatherCalculationPeriods()).map(f->f.build()).orElse(null);
			this.weatherCalculationPeriodsReference = ofNullable(builder.getWeatherCalculationPeriodsReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriods")
		public WeatherCalculationPeriods getWeatherCalculationPeriods() {
			return weatherCalculationPeriods;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriodsReference")
		public CalculationPeriodsReference getWeatherCalculationPeriodsReference() {
			return weatherCalculationPeriodsReference;
		}
		
		@Override
		public WeatherCalculationPeriodModel build() {
			return this;
		}
		
		@Override
		public WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder toBuilder() {
			WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder builder) {
			ofNullable(getWeatherCalculationPeriods()).ifPresent(builder::setWeatherCalculationPeriods);
			ofNullable(getWeatherCalculationPeriodsReference()).ifPresent(builder::setWeatherCalculationPeriodsReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherCalculationPeriodModel _that = getType().cast(o);
		
			if (!Objects.equals(weatherCalculationPeriods, _that.getWeatherCalculationPeriods())) return false;
			if (!Objects.equals(weatherCalculationPeriodsReference, _that.getWeatherCalculationPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (weatherCalculationPeriods != null ? weatherCalculationPeriods.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodsReference != null ? weatherCalculationPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherCalculationPeriodModel {" +
				"weatherCalculationPeriods=" + this.weatherCalculationPeriods + ", " +
				"weatherCalculationPeriodsReference=" + this.weatherCalculationPeriodsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherCalculationPeriodModel  ***********************/
	class WeatherCalculationPeriodModelBuilderImpl implements WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder {
	
		protected WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder weatherCalculationPeriods;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder weatherCalculationPeriodsReference;
	
		public WeatherCalculationPeriodModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("weatherCalculationPeriods")
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getWeatherCalculationPeriods() {
			return weatherCalculationPeriods;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getOrCreateWeatherCalculationPeriods() {
			WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder result;
			if (weatherCalculationPeriods!=null) {
				result = weatherCalculationPeriods;
			}
			else {
				result = weatherCalculationPeriods = WeatherCalculationPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getWeatherCalculationPeriodsReference() {
			return weatherCalculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateWeatherCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (weatherCalculationPeriodsReference!=null) {
				result = weatherCalculationPeriodsReference;
			}
			else {
				result = weatherCalculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriods")
		public WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder setWeatherCalculationPeriods(WeatherCalculationPeriods weatherCalculationPeriods) {
			this.weatherCalculationPeriods = weatherCalculationPeriods==null?null:weatherCalculationPeriods.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weatherCalculationPeriodsReference")
		public WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder setWeatherCalculationPeriodsReference(CalculationPeriodsReference weatherCalculationPeriodsReference) {
			this.weatherCalculationPeriodsReference = weatherCalculationPeriodsReference==null?null:weatherCalculationPeriodsReference.toBuilder();
			return this;
		}
		
		@Override
		public WeatherCalculationPeriodModel build() {
			return new WeatherCalculationPeriodModel.WeatherCalculationPeriodModelImpl(this);
		}
		
		@Override
		public WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder prune() {
			if (weatherCalculationPeriods!=null && !weatherCalculationPeriods.prune().hasData()) weatherCalculationPeriods = null;
			if (weatherCalculationPeriodsReference!=null && !weatherCalculationPeriodsReference.prune().hasData()) weatherCalculationPeriodsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getWeatherCalculationPeriods()!=null && getWeatherCalculationPeriods().hasData()) return true;
			if (getWeatherCalculationPeriodsReference()!=null && getWeatherCalculationPeriodsReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder o = (WeatherCalculationPeriodModel.WeatherCalculationPeriodModelBuilder) other;
			
			merger.mergeRosetta(getWeatherCalculationPeriods(), o.getWeatherCalculationPeriods(), this::setWeatherCalculationPeriods);
			merger.mergeRosetta(getWeatherCalculationPeriodsReference(), o.getWeatherCalculationPeriodsReference(), this::setWeatherCalculationPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherCalculationPeriodModel _that = getType().cast(o);
		
			if (!Objects.equals(weatherCalculationPeriods, _that.getWeatherCalculationPeriods())) return false;
			if (!Objects.equals(weatherCalculationPeriodsReference, _that.getWeatherCalculationPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (weatherCalculationPeriods != null ? weatherCalculationPeriods.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodsReference != null ? weatherCalculationPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherCalculationPeriodModelBuilder {" +
				"weatherCalculationPeriods=" + this.weatherCalculationPeriods + ", " +
				"weatherCalculationPeriodsReference=" + this.weatherCalculationPeriodsReference +
			'}';
		}
	}
}
