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
import fpml.confirmation.CreditSupportAgreementType;
import fpml.confirmation.CreditSupportAgreementType.CreditSupportAgreementTypeBuilder;
import fpml.confirmation.CreditSupportAgreementType.CreditSupportAgreementTypeBuilderImpl;
import fpml.confirmation.CreditSupportAgreementType.CreditSupportAgreementTypeImpl;
import fpml.confirmation.meta.CreditSupportAgreementTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CreditSupportAgreementType", builder=CreditSupportAgreementType.CreditSupportAgreementTypeBuilderImpl.class, version="${project.version}")
public interface CreditSupportAgreementType extends RosettaModelObject {

	CreditSupportAgreementTypeMeta metaData = new CreditSupportAgreementTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCreditSupportAgreementTypeScheme();

	/*********************** Build Methods  ***********************/
	CreditSupportAgreementType build();
	
	CreditSupportAgreementType.CreditSupportAgreementTypeBuilder toBuilder();
	
	static CreditSupportAgreementType.CreditSupportAgreementTypeBuilder builder() {
		return new CreditSupportAgreementType.CreditSupportAgreementTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportAgreementType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditSupportAgreementType> getType() {
		return CreditSupportAgreementType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditSupportAgreementTypeScheme"), String.class, getCreditSupportAgreementTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportAgreementTypeBuilder extends CreditSupportAgreementType, RosettaModelObjectBuilder {
		CreditSupportAgreementType.CreditSupportAgreementTypeBuilder setValue(String value);
		CreditSupportAgreementType.CreditSupportAgreementTypeBuilder setCreditSupportAgreementTypeScheme(String creditSupportAgreementTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditSupportAgreementTypeScheme"), String.class, getCreditSupportAgreementTypeScheme(), this);
		}
		

		CreditSupportAgreementType.CreditSupportAgreementTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportAgreementType  ***********************/
	class CreditSupportAgreementTypeImpl implements CreditSupportAgreementType {
		private final String value;
		private final String creditSupportAgreementTypeScheme;
		
		protected CreditSupportAgreementTypeImpl(CreditSupportAgreementType.CreditSupportAgreementTypeBuilder builder) {
			this.value = builder.getValue();
			this.creditSupportAgreementTypeScheme = builder.getCreditSupportAgreementTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementTypeScheme")
		public String getCreditSupportAgreementTypeScheme() {
			return creditSupportAgreementTypeScheme;
		}
		
		@Override
		public CreditSupportAgreementType build() {
			return this;
		}
		
		@Override
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder toBuilder() {
			CreditSupportAgreementType.CreditSupportAgreementTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAgreementType.CreditSupportAgreementTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditSupportAgreementTypeScheme()).ifPresent(builder::setCreditSupportAgreementTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditSupportAgreementTypeScheme, _that.getCreditSupportAgreementTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementTypeScheme != null ? creditSupportAgreementTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementType {" +
				"value=" + this.value + ", " +
				"creditSupportAgreementTypeScheme=" + this.creditSupportAgreementTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportAgreementType  ***********************/
	class CreditSupportAgreementTypeBuilderImpl implements CreditSupportAgreementType.CreditSupportAgreementTypeBuilder {
	
		protected String value;
		protected String creditSupportAgreementTypeScheme;
	
		public CreditSupportAgreementTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementTypeScheme")
		public String getCreditSupportAgreementTypeScheme() {
			return creditSupportAgreementTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("creditSupportAgreementTypeScheme")
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder setCreditSupportAgreementTypeScheme(String creditSupportAgreementTypeScheme) {
			this.creditSupportAgreementTypeScheme = creditSupportAgreementTypeScheme==null?null:creditSupportAgreementTypeScheme;
			return this;
		}
		
		@Override
		public CreditSupportAgreementType build() {
			return new CreditSupportAgreementType.CreditSupportAgreementTypeImpl(this);
		}
		
		@Override
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditSupportAgreementTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAgreementType.CreditSupportAgreementTypeBuilder o = (CreditSupportAgreementType.CreditSupportAgreementTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditSupportAgreementTypeScheme(), o.getCreditSupportAgreementTypeScheme(), this::setCreditSupportAgreementTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditSupportAgreementTypeScheme, _that.getCreditSupportAgreementTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementTypeScheme != null ? creditSupportAgreementTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementTypeBuilder {" +
				"value=" + this.value + ", " +
				"creditSupportAgreementTypeScheme=" + this.creditSupportAgreementTypeScheme +
			'}';
		}
	}
}
