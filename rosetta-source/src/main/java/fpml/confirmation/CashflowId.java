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
import fpml.confirmation.CashflowId;
import fpml.confirmation.CashflowId.CashflowIdBuilder;
import fpml.confirmation.CashflowId.CashflowIdBuilderImpl;
import fpml.confirmation.CashflowId.CashflowIdImpl;
import fpml.confirmation.meta.CashflowIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An identifier used to identify a single component cashflow.
 * @version ${project.version}
 */
@RosettaDataType(value="CashflowId", builder=CashflowId.CashflowIdBuilderImpl.class, version="${project.version}")
public interface CashflowId extends RosettaModelObject {

	CashflowIdMeta metaData = new CashflowIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCashflowIdScheme();

	/*********************** Build Methods  ***********************/
	CashflowId build();
	
	CashflowId.CashflowIdBuilder toBuilder();
	
	static CashflowId.CashflowIdBuilder builder() {
		return new CashflowId.CashflowIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashflowId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashflowId> getType() {
		return CashflowId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("cashflowIdScheme"), String.class, getCashflowIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowIdBuilder extends CashflowId, RosettaModelObjectBuilder {
		CashflowId.CashflowIdBuilder setValue(String value);
		CashflowId.CashflowIdBuilder setCashflowIdScheme(String cashflowIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("cashflowIdScheme"), String.class, getCashflowIdScheme(), this);
		}
		

		CashflowId.CashflowIdBuilder prune();
	}

	/*********************** Immutable Implementation of CashflowId  ***********************/
	class CashflowIdImpl implements CashflowId {
		private final String value;
		private final String cashflowIdScheme;
		
		protected CashflowIdImpl(CashflowId.CashflowIdBuilder builder) {
			this.value = builder.getValue();
			this.cashflowIdScheme = builder.getCashflowIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("cashflowIdScheme")
		public String getCashflowIdScheme() {
			return cashflowIdScheme;
		}
		
		@Override
		public CashflowId build() {
			return this;
		}
		
		@Override
		public CashflowId.CashflowIdBuilder toBuilder() {
			CashflowId.CashflowIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashflowId.CashflowIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCashflowIdScheme()).ifPresent(builder::setCashflowIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(cashflowIdScheme, _that.getCashflowIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (cashflowIdScheme != null ? cashflowIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowId {" +
				"value=" + this.value + ", " +
				"cashflowIdScheme=" + this.cashflowIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CashflowId  ***********************/
	class CashflowIdBuilderImpl implements CashflowId.CashflowIdBuilder {
	
		protected String value;
		protected String cashflowIdScheme;
	
		public CashflowIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("cashflowIdScheme")
		public String getCashflowIdScheme() {
			return cashflowIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CashflowId.CashflowIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("cashflowIdScheme")
		public CashflowId.CashflowIdBuilder setCashflowIdScheme(String cashflowIdScheme) {
			this.cashflowIdScheme = cashflowIdScheme==null?null:cashflowIdScheme;
			return this;
		}
		
		@Override
		public CashflowId build() {
			return new CashflowId.CashflowIdImpl(this);
		}
		
		@Override
		public CashflowId.CashflowIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowId.CashflowIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCashflowIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowId.CashflowIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashflowId.CashflowIdBuilder o = (CashflowId.CashflowIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCashflowIdScheme(), o.getCashflowIdScheme(), this::setCashflowIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(cashflowIdScheme, _that.getCashflowIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (cashflowIdScheme != null ? cashflowIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowIdBuilder {" +
				"value=" + this.value + ", " +
				"cashflowIdScheme=" + this.cashflowIdScheme +
			'}';
		}
	}
}
