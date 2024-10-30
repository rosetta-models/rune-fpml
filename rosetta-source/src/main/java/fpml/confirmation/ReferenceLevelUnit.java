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
import fpml.confirmation.ReferenceLevelUnit;
import fpml.confirmation.ReferenceLevelUnit.ReferenceLevelUnitBuilder;
import fpml.confirmation.ReferenceLevelUnit.ReferenceLevelUnitBuilderImpl;
import fpml.confirmation.ReferenceLevelUnit.ReferenceLevelUnitImpl;
import fpml.confirmation.meta.ReferenceLevelUnitMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * CPD Reference Level: millimeters or inches of daily precipitation HDD Reference Level: degree-days CDD Reference Level: degree-days.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReferenceLevelUnit", builder=ReferenceLevelUnit.ReferenceLevelUnitBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReferenceLevelUnit extends RosettaModelObject {

	ReferenceLevelUnitMeta metaData = new ReferenceLevelUnitMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getWeatherIndexReferenceLevelScheme();

	/*********************** Build Methods  ***********************/
	ReferenceLevelUnit build();
	
	ReferenceLevelUnit.ReferenceLevelUnitBuilder toBuilder();
	
	static ReferenceLevelUnit.ReferenceLevelUnitBuilder builder() {
		return new ReferenceLevelUnit.ReferenceLevelUnitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceLevelUnit> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceLevelUnit> getType() {
		return ReferenceLevelUnit.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("weatherIndexReferenceLevelScheme"), String.class, getWeatherIndexReferenceLevelScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceLevelUnitBuilder extends ReferenceLevelUnit, RosettaModelObjectBuilder {
		ReferenceLevelUnit.ReferenceLevelUnitBuilder setValue(String value);
		ReferenceLevelUnit.ReferenceLevelUnitBuilder setWeatherIndexReferenceLevelScheme(String weatherIndexReferenceLevelScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("weatherIndexReferenceLevelScheme"), String.class, getWeatherIndexReferenceLevelScheme(), this);
		}
		

		ReferenceLevelUnit.ReferenceLevelUnitBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceLevelUnit  ***********************/
	class ReferenceLevelUnitImpl implements ReferenceLevelUnit {
		private final String value;
		private final String weatherIndexReferenceLevelScheme;
		
		protected ReferenceLevelUnitImpl(ReferenceLevelUnit.ReferenceLevelUnitBuilder builder) {
			this.value = builder.getValue();
			this.weatherIndexReferenceLevelScheme = builder.getWeatherIndexReferenceLevelScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherIndexReferenceLevelScheme")
		public String getWeatherIndexReferenceLevelScheme() {
			return weatherIndexReferenceLevelScheme;
		}
		
		@Override
		public ReferenceLevelUnit build() {
			return this;
		}
		
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder toBuilder() {
			ReferenceLevelUnit.ReferenceLevelUnitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceLevelUnit.ReferenceLevelUnitBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWeatherIndexReferenceLevelScheme()).ifPresent(builder::setWeatherIndexReferenceLevelScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceLevelUnit _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherIndexReferenceLevelScheme, _that.getWeatherIndexReferenceLevelScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherIndexReferenceLevelScheme != null ? weatherIndexReferenceLevelScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceLevelUnit {" +
				"value=" + this.value + ", " +
				"weatherIndexReferenceLevelScheme=" + this.weatherIndexReferenceLevelScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceLevelUnit  ***********************/
	class ReferenceLevelUnitBuilderImpl implements ReferenceLevelUnit.ReferenceLevelUnitBuilder {
	
		protected String value;
		protected String weatherIndexReferenceLevelScheme;
	
		public ReferenceLevelUnitBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherIndexReferenceLevelScheme")
		public String getWeatherIndexReferenceLevelScheme() {
			return weatherIndexReferenceLevelScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("weatherIndexReferenceLevelScheme")
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder setWeatherIndexReferenceLevelScheme(String weatherIndexReferenceLevelScheme) {
			this.weatherIndexReferenceLevelScheme = weatherIndexReferenceLevelScheme==null?null:weatherIndexReferenceLevelScheme;
			return this;
		}
		
		@Override
		public ReferenceLevelUnit build() {
			return new ReferenceLevelUnit.ReferenceLevelUnitImpl(this);
		}
		
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWeatherIndexReferenceLevelScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceLevelUnit.ReferenceLevelUnitBuilder o = (ReferenceLevelUnit.ReferenceLevelUnitBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWeatherIndexReferenceLevelScheme(), o.getWeatherIndexReferenceLevelScheme(), this::setWeatherIndexReferenceLevelScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceLevelUnit _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherIndexReferenceLevelScheme, _that.getWeatherIndexReferenceLevelScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherIndexReferenceLevelScheme != null ? weatherIndexReferenceLevelScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceLevelUnitBuilder {" +
				"value=" + this.value + ", " +
				"weatherIndexReferenceLevelScheme=" + this.weatherIndexReferenceLevelScheme +
			'}';
		}
	}
}
