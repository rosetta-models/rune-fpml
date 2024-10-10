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
import fpml.confirmation.CreditSupportAgreementIdentifier;
import fpml.confirmation.CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder;
import fpml.confirmation.CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilderImpl;
import fpml.confirmation.CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierImpl;
import fpml.confirmation.meta.CreditSupportAgreementIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CreditSupportAgreementIdentifier", builder=CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilderImpl.class, version="${project.version}")
public interface CreditSupportAgreementIdentifier extends RosettaModelObject {

	CreditSupportAgreementIdentifierMeta metaData = new CreditSupportAgreementIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCreditSupportAgreementIdScheme();

	/*********************** Build Methods  ***********************/
	CreditSupportAgreementIdentifier build();
	
	CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder toBuilder();
	
	static CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder builder() {
		return new CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportAgreementIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditSupportAgreementIdentifier> getType() {
		return CreditSupportAgreementIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditSupportAgreementIdScheme"), String.class, getCreditSupportAgreementIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportAgreementIdentifierBuilder extends CreditSupportAgreementIdentifier, RosettaModelObjectBuilder {
		CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder setValue(String value);
		CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder setCreditSupportAgreementIdScheme(String creditSupportAgreementIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditSupportAgreementIdScheme"), String.class, getCreditSupportAgreementIdScheme(), this);
		}
		

		CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportAgreementIdentifier  ***********************/
	class CreditSupportAgreementIdentifierImpl implements CreditSupportAgreementIdentifier {
		private final String value;
		private final String creditSupportAgreementIdScheme;
		
		protected CreditSupportAgreementIdentifierImpl(CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder builder) {
			this.value = builder.getValue();
			this.creditSupportAgreementIdScheme = builder.getCreditSupportAgreementIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementIdScheme")
		public String getCreditSupportAgreementIdScheme() {
			return creditSupportAgreementIdScheme;
		}
		
		@Override
		public CreditSupportAgreementIdentifier build() {
			return this;
		}
		
		@Override
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder toBuilder() {
			CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditSupportAgreementIdScheme()).ifPresent(builder::setCreditSupportAgreementIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreementIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditSupportAgreementIdScheme, _that.getCreditSupportAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementIdScheme != null ? creditSupportAgreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementIdentifier {" +
				"value=" + this.value + ", " +
				"creditSupportAgreementIdScheme=" + this.creditSupportAgreementIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportAgreementIdentifier  ***********************/
	class CreditSupportAgreementIdentifierBuilderImpl implements CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder {
	
		protected String value;
		protected String creditSupportAgreementIdScheme;
	
		public CreditSupportAgreementIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementIdScheme")
		public String getCreditSupportAgreementIdScheme() {
			return creditSupportAgreementIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("creditSupportAgreementIdScheme")
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder setCreditSupportAgreementIdScheme(String creditSupportAgreementIdScheme) {
			this.creditSupportAgreementIdScheme = creditSupportAgreementIdScheme==null?null:creditSupportAgreementIdScheme;
			return this;
		}
		
		@Override
		public CreditSupportAgreementIdentifier build() {
			return new CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierImpl(this);
		}
		
		@Override
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditSupportAgreementIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder o = (CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditSupportAgreementIdScheme(), o.getCreditSupportAgreementIdScheme(), this::setCreditSupportAgreementIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreementIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditSupportAgreementIdScheme, _that.getCreditSupportAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementIdScheme != null ? creditSupportAgreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementIdentifierBuilder {" +
				"value=" + this.value + ", " +
				"creditSupportAgreementIdScheme=" + this.creditSupportAgreementIdScheme +
			'}';
		}
	}
}
