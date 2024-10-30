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
import fpml.confirmation.NonRecurringMiscFeeType;
import fpml.confirmation.NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder;
import fpml.confirmation.NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilderImpl;
import fpml.confirmation.NonRecurringMiscFeeType.NonRecurringMiscFeeTypeImpl;
import fpml.confirmation.meta.NonRecurringMiscFeeTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A list of all non-recurring (one-off) fee types.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NonRecurringMiscFeeType", builder=NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NonRecurringMiscFeeType extends RosettaModelObject {

	NonRecurringMiscFeeTypeMeta metaData = new NonRecurringMiscFeeTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getNonRecurringMiscFeeTypeScheme();

	/*********************** Build Methods  ***********************/
	NonRecurringMiscFeeType build();
	
	NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder toBuilder();
	
	static NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder builder() {
		return new NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonRecurringMiscFeeType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonRecurringMiscFeeType> getType() {
		return NonRecurringMiscFeeType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("nonRecurringMiscFeeTypeScheme"), String.class, getNonRecurringMiscFeeTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonRecurringMiscFeeTypeBuilder extends NonRecurringMiscFeeType, RosettaModelObjectBuilder {
		NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder setValue(String value);
		NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder setNonRecurringMiscFeeTypeScheme(String nonRecurringMiscFeeTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("nonRecurringMiscFeeTypeScheme"), String.class, getNonRecurringMiscFeeTypeScheme(), this);
		}
		

		NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder prune();
	}

	/*********************** Immutable Implementation of NonRecurringMiscFeeType  ***********************/
	class NonRecurringMiscFeeTypeImpl implements NonRecurringMiscFeeType {
		private final String value;
		private final String nonRecurringMiscFeeTypeScheme;
		
		protected NonRecurringMiscFeeTypeImpl(NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder builder) {
			this.value = builder.getValue();
			this.nonRecurringMiscFeeTypeScheme = builder.getNonRecurringMiscFeeTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("nonRecurringMiscFeeTypeScheme")
		public String getNonRecurringMiscFeeTypeScheme() {
			return nonRecurringMiscFeeTypeScheme;
		}
		
		@Override
		public NonRecurringMiscFeeType build() {
			return this;
		}
		
		@Override
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder toBuilder() {
			NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getNonRecurringMiscFeeTypeScheme()).ifPresent(builder::setNonRecurringMiscFeeTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonRecurringMiscFeeType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(nonRecurringMiscFeeTypeScheme, _that.getNonRecurringMiscFeeTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (nonRecurringMiscFeeTypeScheme != null ? nonRecurringMiscFeeTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonRecurringMiscFeeType {" +
				"value=" + this.value + ", " +
				"nonRecurringMiscFeeTypeScheme=" + this.nonRecurringMiscFeeTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of NonRecurringMiscFeeType  ***********************/
	class NonRecurringMiscFeeTypeBuilderImpl implements NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder {
	
		protected String value;
		protected String nonRecurringMiscFeeTypeScheme;
	
		public NonRecurringMiscFeeTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("nonRecurringMiscFeeTypeScheme")
		public String getNonRecurringMiscFeeTypeScheme() {
			return nonRecurringMiscFeeTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("nonRecurringMiscFeeTypeScheme")
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder setNonRecurringMiscFeeTypeScheme(String nonRecurringMiscFeeTypeScheme) {
			this.nonRecurringMiscFeeTypeScheme = nonRecurringMiscFeeTypeScheme==null?null:nonRecurringMiscFeeTypeScheme;
			return this;
		}
		
		@Override
		public NonRecurringMiscFeeType build() {
			return new NonRecurringMiscFeeType.NonRecurringMiscFeeTypeImpl(this);
		}
		
		@Override
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getNonRecurringMiscFeeTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder o = (NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getNonRecurringMiscFeeTypeScheme(), o.getNonRecurringMiscFeeTypeScheme(), this::setNonRecurringMiscFeeTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonRecurringMiscFeeType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(nonRecurringMiscFeeTypeScheme, _that.getNonRecurringMiscFeeTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (nonRecurringMiscFeeTypeScheme != null ? nonRecurringMiscFeeTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonRecurringMiscFeeTypeBuilder {" +
				"value=" + this.value + ", " +
				"nonRecurringMiscFeeTypeScheme=" + this.nonRecurringMiscFeeTypeScheme +
			'}';
		}
	}
}
