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
import fpml.confirmation.OptionType;
import fpml.confirmation.OptionType.OptionTypeBuilder;
import fpml.confirmation.OptionType.OptionTypeBuilderImpl;
import fpml.confirmation.OptionType.OptionTypeImpl;
import fpml.confirmation.meta.OptionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The type of option transaction (e.g. Call, Put); specifies whether the option allows the holder to buy or sell the underlying asset, or pay or receive a payment related to the price of underlying asset, in the event of exercise.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OptionType", builder=OptionType.OptionTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OptionType extends RosettaModelObject {

	OptionTypeMeta metaData = new OptionTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	/**
	 * The type scheme used with this option type.
	 */
	String getOptionTypeScheme();

	/*********************** Build Methods  ***********************/
	OptionType build();
	
	OptionType.OptionTypeBuilder toBuilder();
	
	static OptionType.OptionTypeBuilder builder() {
		return new OptionType.OptionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionType> getType() {
		return OptionType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("optionTypeScheme"), String.class, getOptionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionTypeBuilder extends OptionType, RosettaModelObjectBuilder {
		OptionType.OptionTypeBuilder setValue(String value);
		OptionType.OptionTypeBuilder setOptionTypeScheme(String optionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("optionTypeScheme"), String.class, getOptionTypeScheme(), this);
		}
		

		OptionType.OptionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of OptionType  ***********************/
	class OptionTypeImpl implements OptionType {
		private final String value;
		private final String optionTypeScheme;
		
		protected OptionTypeImpl(OptionType.OptionTypeBuilder builder) {
			this.value = builder.getValue();
			this.optionTypeScheme = builder.getOptionTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("optionTypeScheme")
		public String getOptionTypeScheme() {
			return optionTypeScheme;
		}
		
		@Override
		public OptionType build() {
			return this;
		}
		
		@Override
		public OptionType.OptionTypeBuilder toBuilder() {
			OptionType.OptionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionType.OptionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getOptionTypeScheme()).ifPresent(builder::setOptionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(optionTypeScheme, _that.getOptionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (optionTypeScheme != null ? optionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionType {" +
				"value=" + this.value + ", " +
				"optionTypeScheme=" + this.optionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionType  ***********************/
	class OptionTypeBuilderImpl implements OptionType.OptionTypeBuilder {
	
		protected String value;
		protected String optionTypeScheme;
	
		public OptionTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("optionTypeScheme")
		public String getOptionTypeScheme() {
			return optionTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public OptionType.OptionTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("optionTypeScheme")
		public OptionType.OptionTypeBuilder setOptionTypeScheme(String optionTypeScheme) {
			this.optionTypeScheme = optionTypeScheme==null?null:optionTypeScheme;
			return this;
		}
		
		@Override
		public OptionType build() {
			return new OptionType.OptionTypeImpl(this);
		}
		
		@Override
		public OptionType.OptionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionType.OptionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getOptionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionType.OptionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionType.OptionTypeBuilder o = (OptionType.OptionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getOptionTypeScheme(), o.getOptionTypeScheme(), this::setOptionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(optionTypeScheme, _that.getOptionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (optionTypeScheme != null ? optionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionTypeBuilder {" +
				"value=" + this.value + ", " +
				"optionTypeScheme=" + this.optionTypeScheme +
			'}';
		}
	}
}
