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
import fpml.confirmation.AccruingFeeType;
import fpml.confirmation.AccruingFeeType.AccruingFeeTypeBuilder;
import fpml.confirmation.AccruingFeeType.AccruingFeeTypeBuilderImpl;
import fpml.confirmation.AccruingFeeType.AccruingFeeTypeImpl;
import fpml.confirmation.meta.AccruingFeeTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A list of all eligible accruing facility-level fee types.
 * @version ${project.version}
 */
@RosettaDataType(value="AccruingFeeType", builder=AccruingFeeType.AccruingFeeTypeBuilderImpl.class, version="${project.version}")
public interface AccruingFeeType extends RosettaModelObject {

	AccruingFeeTypeMeta metaData = new AccruingFeeTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAccruingFeeTypeScheme();

	/*********************** Build Methods  ***********************/
	AccruingFeeType build();
	
	AccruingFeeType.AccruingFeeTypeBuilder toBuilder();
	
	static AccruingFeeType.AccruingFeeTypeBuilder builder() {
		return new AccruingFeeType.AccruingFeeTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingFeeType> getType() {
		return AccruingFeeType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("accruingFeeTypeScheme"), String.class, getAccruingFeeTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeTypeBuilder extends AccruingFeeType, RosettaModelObjectBuilder {
		AccruingFeeType.AccruingFeeTypeBuilder setValue(String value);
		AccruingFeeType.AccruingFeeTypeBuilder setAccruingFeeTypeScheme(String accruingFeeTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("accruingFeeTypeScheme"), String.class, getAccruingFeeTypeScheme(), this);
		}
		

		AccruingFeeType.AccruingFeeTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeType  ***********************/
	class AccruingFeeTypeImpl implements AccruingFeeType {
		private final String value;
		private final String accruingFeeTypeScheme;
		
		protected AccruingFeeTypeImpl(AccruingFeeType.AccruingFeeTypeBuilder builder) {
			this.value = builder.getValue();
			this.accruingFeeTypeScheme = builder.getAccruingFeeTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accruingFeeTypeScheme")
		public String getAccruingFeeTypeScheme() {
			return accruingFeeTypeScheme;
		}
		
		@Override
		public AccruingFeeType build() {
			return this;
		}
		
		@Override
		public AccruingFeeType.AccruingFeeTypeBuilder toBuilder() {
			AccruingFeeType.AccruingFeeTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeType.AccruingFeeTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAccruingFeeTypeScheme()).ifPresent(builder::setAccruingFeeTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccruingFeeType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accruingFeeTypeScheme, _that.getAccruingFeeTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accruingFeeTypeScheme != null ? accruingFeeTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeType {" +
				"value=" + this.value + ", " +
				"accruingFeeTypeScheme=" + this.accruingFeeTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AccruingFeeType  ***********************/
	class AccruingFeeTypeBuilderImpl implements AccruingFeeType.AccruingFeeTypeBuilder {
	
		protected String value;
		protected String accruingFeeTypeScheme;
	
		public AccruingFeeTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accruingFeeTypeScheme")
		public String getAccruingFeeTypeScheme() {
			return accruingFeeTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public AccruingFeeType.AccruingFeeTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("accruingFeeTypeScheme")
		public AccruingFeeType.AccruingFeeTypeBuilder setAccruingFeeTypeScheme(String accruingFeeTypeScheme) {
			this.accruingFeeTypeScheme = accruingFeeTypeScheme==null?null:accruingFeeTypeScheme;
			return this;
		}
		
		@Override
		public AccruingFeeType build() {
			return new AccruingFeeType.AccruingFeeTypeImpl(this);
		}
		
		@Override
		public AccruingFeeType.AccruingFeeTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeType.AccruingFeeTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAccruingFeeTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeType.AccruingFeeTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccruingFeeType.AccruingFeeTypeBuilder o = (AccruingFeeType.AccruingFeeTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAccruingFeeTypeScheme(), o.getAccruingFeeTypeScheme(), this::setAccruingFeeTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccruingFeeType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accruingFeeTypeScheme, _that.getAccruingFeeTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accruingFeeTypeScheme != null ? accruingFeeTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeTypeBuilder {" +
				"value=" + this.value + ", " +
				"accruingFeeTypeScheme=" + this.accruingFeeTypeScheme +
			'}';
		}
	}
}
