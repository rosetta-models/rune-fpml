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
import fpml.confirmation.TaxFormType;
import fpml.confirmation.TaxFormType.TaxFormTypeBuilder;
import fpml.confirmation.TaxFormType.TaxFormTypeBuilderImpl;
import fpml.confirmation.TaxFormType.TaxFormTypeImpl;
import fpml.confirmation.meta.TaxFormTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme that describes tax form types.
 * @version ${project.version}
 */
@RosettaDataType(value="TaxFormType", builder=TaxFormType.TaxFormTypeBuilderImpl.class, version="${project.version}")
public interface TaxFormType extends RosettaModelObject {

	TaxFormTypeMeta metaData = new TaxFormTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTaxFormTypeScheme();

	/*********************** Build Methods  ***********************/
	TaxFormType build();
	
	TaxFormType.TaxFormTypeBuilder toBuilder();
	
	static TaxFormType.TaxFormTypeBuilder builder() {
		return new TaxFormType.TaxFormTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaxFormType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TaxFormType> getType() {
		return TaxFormType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("taxFormTypeScheme"), String.class, getTaxFormTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaxFormTypeBuilder extends TaxFormType, RosettaModelObjectBuilder {
		TaxFormType.TaxFormTypeBuilder setValue(String value);
		TaxFormType.TaxFormTypeBuilder setTaxFormTypeScheme(String taxFormTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("taxFormTypeScheme"), String.class, getTaxFormTypeScheme(), this);
		}
		

		TaxFormType.TaxFormTypeBuilder prune();
	}

	/*********************** Immutable Implementation of TaxFormType  ***********************/
	class TaxFormTypeImpl implements TaxFormType {
		private final String value;
		private final String taxFormTypeScheme;
		
		protected TaxFormTypeImpl(TaxFormType.TaxFormTypeBuilder builder) {
			this.value = builder.getValue();
			this.taxFormTypeScheme = builder.getTaxFormTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("taxFormTypeScheme")
		public String getTaxFormTypeScheme() {
			return taxFormTypeScheme;
		}
		
		@Override
		public TaxFormType build() {
			return this;
		}
		
		@Override
		public TaxFormType.TaxFormTypeBuilder toBuilder() {
			TaxFormType.TaxFormTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaxFormType.TaxFormTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTaxFormTypeScheme()).ifPresent(builder::setTaxFormTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaxFormType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(taxFormTypeScheme, _that.getTaxFormTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (taxFormTypeScheme != null ? taxFormTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaxFormType {" +
				"value=" + this.value + ", " +
				"taxFormTypeScheme=" + this.taxFormTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TaxFormType  ***********************/
	class TaxFormTypeBuilderImpl implements TaxFormType.TaxFormTypeBuilder {
	
		protected String value;
		protected String taxFormTypeScheme;
	
		public TaxFormTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("taxFormTypeScheme")
		public String getTaxFormTypeScheme() {
			return taxFormTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public TaxFormType.TaxFormTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("taxFormTypeScheme")
		public TaxFormType.TaxFormTypeBuilder setTaxFormTypeScheme(String taxFormTypeScheme) {
			this.taxFormTypeScheme = taxFormTypeScheme==null?null:taxFormTypeScheme;
			return this;
		}
		
		@Override
		public TaxFormType build() {
			return new TaxFormType.TaxFormTypeImpl(this);
		}
		
		@Override
		public TaxFormType.TaxFormTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaxFormType.TaxFormTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTaxFormTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaxFormType.TaxFormTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaxFormType.TaxFormTypeBuilder o = (TaxFormType.TaxFormTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTaxFormTypeScheme(), o.getTaxFormTypeScheme(), this::setTaxFormTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaxFormType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(taxFormTypeScheme, _that.getTaxFormTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (taxFormTypeScheme != null ? taxFormTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaxFormTypeBuilder {" +
				"value=" + this.value + ", " +
				"taxFormTypeScheme=" + this.taxFormTypeScheme +
			'}';
		}
	}
}
