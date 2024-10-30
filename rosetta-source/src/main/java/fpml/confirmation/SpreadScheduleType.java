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
import fpml.confirmation.SpreadScheduleType;
import fpml.confirmation.SpreadScheduleType.SpreadScheduleTypeBuilder;
import fpml.confirmation.SpreadScheduleType.SpreadScheduleTypeBuilderImpl;
import fpml.confirmation.SpreadScheduleType.SpreadScheduleTypeImpl;
import fpml.confirmation.meta.SpreadScheduleTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a Spread Type Scheme to identify a long or short spread value.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SpreadScheduleType", builder=SpreadScheduleType.SpreadScheduleTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SpreadScheduleType extends RosettaModelObject {

	SpreadScheduleTypeMeta metaData = new SpreadScheduleTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getSpreadScheduleTypeScheme();

	/*********************** Build Methods  ***********************/
	SpreadScheduleType build();
	
	SpreadScheduleType.SpreadScheduleTypeBuilder toBuilder();
	
	static SpreadScheduleType.SpreadScheduleTypeBuilder builder() {
		return new SpreadScheduleType.SpreadScheduleTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpreadScheduleType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SpreadScheduleType> getType() {
		return SpreadScheduleType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("spreadScheduleTypeScheme"), String.class, getSpreadScheduleTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpreadScheduleTypeBuilder extends SpreadScheduleType, RosettaModelObjectBuilder {
		SpreadScheduleType.SpreadScheduleTypeBuilder setValue(String value);
		SpreadScheduleType.SpreadScheduleTypeBuilder setSpreadScheduleTypeScheme(String spreadScheduleTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("spreadScheduleTypeScheme"), String.class, getSpreadScheduleTypeScheme(), this);
		}
		

		SpreadScheduleType.SpreadScheduleTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SpreadScheduleType  ***********************/
	class SpreadScheduleTypeImpl implements SpreadScheduleType {
		private final String value;
		private final String spreadScheduleTypeScheme;
		
		protected SpreadScheduleTypeImpl(SpreadScheduleType.SpreadScheduleTypeBuilder builder) {
			this.value = builder.getValue();
			this.spreadScheduleTypeScheme = builder.getSpreadScheduleTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("spreadScheduleTypeScheme")
		public String getSpreadScheduleTypeScheme() {
			return spreadScheduleTypeScheme;
		}
		
		@Override
		public SpreadScheduleType build() {
			return this;
		}
		
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder toBuilder() {
			SpreadScheduleType.SpreadScheduleTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpreadScheduleType.SpreadScheduleTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSpreadScheduleTypeScheme()).ifPresent(builder::setSpreadScheduleTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpreadScheduleType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(spreadScheduleTypeScheme, _that.getSpreadScheduleTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (spreadScheduleTypeScheme != null ? spreadScheduleTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleType {" +
				"value=" + this.value + ", " +
				"spreadScheduleTypeScheme=" + this.spreadScheduleTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of SpreadScheduleType  ***********************/
	class SpreadScheduleTypeBuilderImpl implements SpreadScheduleType.SpreadScheduleTypeBuilder {
	
		protected String value;
		protected String spreadScheduleTypeScheme;
	
		public SpreadScheduleTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("spreadScheduleTypeScheme")
		public String getSpreadScheduleTypeScheme() {
			return spreadScheduleTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public SpreadScheduleType.SpreadScheduleTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("spreadScheduleTypeScheme")
		public SpreadScheduleType.SpreadScheduleTypeBuilder setSpreadScheduleTypeScheme(String spreadScheduleTypeScheme) {
			this.spreadScheduleTypeScheme = spreadScheduleTypeScheme==null?null:spreadScheduleTypeScheme;
			return this;
		}
		
		@Override
		public SpreadScheduleType build() {
			return new SpreadScheduleType.SpreadScheduleTypeImpl(this);
		}
		
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSpreadScheduleTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpreadScheduleType.SpreadScheduleTypeBuilder o = (SpreadScheduleType.SpreadScheduleTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSpreadScheduleTypeScheme(), o.getSpreadScheduleTypeScheme(), this::setSpreadScheduleTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpreadScheduleType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(spreadScheduleTypeScheme, _that.getSpreadScheduleTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (spreadScheduleTypeScheme != null ? spreadScheduleTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleTypeBuilder {" +
				"value=" + this.value + ", " +
				"spreadScheduleTypeScheme=" + this.spreadScheduleTypeScheme +
			'}';
		}
	}
}
