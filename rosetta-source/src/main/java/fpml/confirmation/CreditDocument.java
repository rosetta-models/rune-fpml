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
import fpml.confirmation.CreditDocument;
import fpml.confirmation.CreditDocument.CreditDocumentBuilder;
import fpml.confirmation.CreditDocument.CreditDocumentBuilderImpl;
import fpml.confirmation.CreditDocument.CreditDocumentImpl;
import fpml.confirmation.meta.CreditDocumentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A credit arrangement used in support of swaps trading.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditDocument", builder=CreditDocument.CreditDocumentBuilderImpl.class, version="${project.version}")
public interface CreditDocument extends RosettaModelObject {

	CreditDocumentMeta metaData = new CreditDocumentMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCreditDocumentScheme();

	/*********************** Build Methods  ***********************/
	CreditDocument build();
	
	CreditDocument.CreditDocumentBuilder toBuilder();
	
	static CreditDocument.CreditDocumentBuilder builder() {
		return new CreditDocument.CreditDocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDocument> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditDocument> getType() {
		return CreditDocument.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditDocumentScheme"), String.class, getCreditDocumentScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDocumentBuilder extends CreditDocument, RosettaModelObjectBuilder {
		CreditDocument.CreditDocumentBuilder setValue(String value);
		CreditDocument.CreditDocumentBuilder setCreditDocumentScheme(String creditDocumentScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditDocumentScheme"), String.class, getCreditDocumentScheme(), this);
		}
		

		CreditDocument.CreditDocumentBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDocument  ***********************/
	class CreditDocumentImpl implements CreditDocument {
		private final String value;
		private final String creditDocumentScheme;
		
		protected CreditDocumentImpl(CreditDocument.CreditDocumentBuilder builder) {
			this.value = builder.getValue();
			this.creditDocumentScheme = builder.getCreditDocumentScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditDocumentScheme")
		public String getCreditDocumentScheme() {
			return creditDocumentScheme;
		}
		
		@Override
		public CreditDocument build() {
			return this;
		}
		
		@Override
		public CreditDocument.CreditDocumentBuilder toBuilder() {
			CreditDocument.CreditDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDocument.CreditDocumentBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditDocumentScheme()).ifPresent(builder::setCreditDocumentScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDocument _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditDocumentScheme, _that.getCreditDocumentScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditDocumentScheme != null ? creditDocumentScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDocument {" +
				"value=" + this.value + ", " +
				"creditDocumentScheme=" + this.creditDocumentScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditDocument  ***********************/
	class CreditDocumentBuilderImpl implements CreditDocument.CreditDocumentBuilder {
	
		protected String value;
		protected String creditDocumentScheme;
	
		public CreditDocumentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditDocumentScheme")
		public String getCreditDocumentScheme() {
			return creditDocumentScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CreditDocument.CreditDocumentBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("creditDocumentScheme")
		public CreditDocument.CreditDocumentBuilder setCreditDocumentScheme(String creditDocumentScheme) {
			this.creditDocumentScheme = creditDocumentScheme==null?null:creditDocumentScheme;
			return this;
		}
		
		@Override
		public CreditDocument build() {
			return new CreditDocument.CreditDocumentImpl(this);
		}
		
		@Override
		public CreditDocument.CreditDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDocument.CreditDocumentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditDocumentScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDocument.CreditDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditDocument.CreditDocumentBuilder o = (CreditDocument.CreditDocumentBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditDocumentScheme(), o.getCreditDocumentScheme(), this::setCreditDocumentScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDocument _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditDocumentScheme, _that.getCreditDocumentScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditDocumentScheme != null ? creditDocumentScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDocumentBuilder {" +
				"value=" + this.value + ", " +
				"creditDocumentScheme=" + this.creditDocumentScheme +
			'}';
		}
	}
}
