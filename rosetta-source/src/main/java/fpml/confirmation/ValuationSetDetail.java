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
import fpml.confirmation.ValuationSetDetail;
import fpml.confirmation.ValuationSetDetail.ValuationSetDetailBuilder;
import fpml.confirmation.ValuationSetDetail.ValuationSetDetailBuilderImpl;
import fpml.confirmation.ValuationSetDetail.ValuationSetDetailImpl;
import fpml.confirmation.meta.ValuationSetDetailMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The amount of detail provided in the valuation set, e.g. is market environment data provided, are risk definitions provided, etc.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ValuationSetDetail", builder=ValuationSetDetail.ValuationSetDetailBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ValuationSetDetail extends RosettaModelObject {

	ValuationSetDetailMeta metaData = new ValuationSetDetailMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getValuationSetDetailScheme();

	/*********************** Build Methods  ***********************/
	ValuationSetDetail build();
	
	ValuationSetDetail.ValuationSetDetailBuilder toBuilder();
	
	static ValuationSetDetail.ValuationSetDetailBuilder builder() {
		return new ValuationSetDetail.ValuationSetDetailBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationSetDetail> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationSetDetail> getType() {
		return ValuationSetDetail.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("valuationSetDetailScheme"), String.class, getValuationSetDetailScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationSetDetailBuilder extends ValuationSetDetail, RosettaModelObjectBuilder {
		ValuationSetDetail.ValuationSetDetailBuilder setValue(String value);
		ValuationSetDetail.ValuationSetDetailBuilder setValuationSetDetailScheme(String valuationSetDetailScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("valuationSetDetailScheme"), String.class, getValuationSetDetailScheme(), this);
		}
		

		ValuationSetDetail.ValuationSetDetailBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationSetDetail  ***********************/
	class ValuationSetDetailImpl implements ValuationSetDetail {
		private final String value;
		private final String valuationSetDetailScheme;
		
		protected ValuationSetDetailImpl(ValuationSetDetail.ValuationSetDetailBuilder builder) {
			this.value = builder.getValue();
			this.valuationSetDetailScheme = builder.getValuationSetDetailScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("valuationSetDetailScheme")
		public String getValuationSetDetailScheme() {
			return valuationSetDetailScheme;
		}
		
		@Override
		public ValuationSetDetail build() {
			return this;
		}
		
		@Override
		public ValuationSetDetail.ValuationSetDetailBuilder toBuilder() {
			ValuationSetDetail.ValuationSetDetailBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationSetDetail.ValuationSetDetailBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getValuationSetDetailScheme()).ifPresent(builder::setValuationSetDetailScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationSetDetail _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(valuationSetDetailScheme, _that.getValuationSetDetailScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (valuationSetDetailScheme != null ? valuationSetDetailScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationSetDetail {" +
				"value=" + this.value + ", " +
				"valuationSetDetailScheme=" + this.valuationSetDetailScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationSetDetail  ***********************/
	class ValuationSetDetailBuilderImpl implements ValuationSetDetail.ValuationSetDetailBuilder {
	
		protected String value;
		protected String valuationSetDetailScheme;
	
		public ValuationSetDetailBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("valuationSetDetailScheme")
		public String getValuationSetDetailScheme() {
			return valuationSetDetailScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ValuationSetDetail.ValuationSetDetailBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("valuationSetDetailScheme")
		public ValuationSetDetail.ValuationSetDetailBuilder setValuationSetDetailScheme(String valuationSetDetailScheme) {
			this.valuationSetDetailScheme = valuationSetDetailScheme==null?null:valuationSetDetailScheme;
			return this;
		}
		
		@Override
		public ValuationSetDetail build() {
			return new ValuationSetDetail.ValuationSetDetailImpl(this);
		}
		
		@Override
		public ValuationSetDetail.ValuationSetDetailBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationSetDetail.ValuationSetDetailBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getValuationSetDetailScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationSetDetail.ValuationSetDetailBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationSetDetail.ValuationSetDetailBuilder o = (ValuationSetDetail.ValuationSetDetailBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getValuationSetDetailScheme(), o.getValuationSetDetailScheme(), this::setValuationSetDetailScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationSetDetail _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(valuationSetDetailScheme, _that.getValuationSetDetailScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (valuationSetDetailScheme != null ? valuationSetDetailScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationSetDetailBuilder {" +
				"value=" + this.value + ", " +
				"valuationSetDetailScheme=" + this.valuationSetDetailScheme +
			'}';
		}
	}
}
