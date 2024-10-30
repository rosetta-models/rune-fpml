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
import fpml.confirmation.LoanTradeSettlementTaskType;
import fpml.confirmation.LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder;
import fpml.confirmation.LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilderImpl;
import fpml.confirmation.LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeImpl;
import fpml.confirmation.meta.LoanTradeSettlementTaskTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that uniquely identifies a settlement task type within a syndicated loan structure.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradeSettlementTaskType", builder=LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradeSettlementTaskType extends RosettaModelObject {

	LoanTradeSettlementTaskTypeMeta metaData = new LoanTradeSettlementTaskTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTradeSettlementTaskTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanTradeSettlementTaskType build();
	
	LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder toBuilder();
	
	static LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder builder() {
		return new LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeSettlementTaskType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeSettlementTaskType> getType() {
		return LoanTradeSettlementTaskType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("tradeSettlementTaskTypeScheme"), String.class, getTradeSettlementTaskTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeSettlementTaskTypeBuilder extends LoanTradeSettlementTaskType, RosettaModelObjectBuilder {
		LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder setValue(String value);
		LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder setTradeSettlementTaskTypeScheme(String tradeSettlementTaskTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("tradeSettlementTaskTypeScheme"), String.class, getTradeSettlementTaskTypeScheme(), this);
		}
		

		LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeSettlementTaskType  ***********************/
	class LoanTradeSettlementTaskTypeImpl implements LoanTradeSettlementTaskType {
		private final String value;
		private final String tradeSettlementTaskTypeScheme;
		
		protected LoanTradeSettlementTaskTypeImpl(LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder builder) {
			this.value = builder.getValue();
			this.tradeSettlementTaskTypeScheme = builder.getTradeSettlementTaskTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradeSettlementTaskTypeScheme")
		public String getTradeSettlementTaskTypeScheme() {
			return tradeSettlementTaskTypeScheme;
		}
		
		@Override
		public LoanTradeSettlementTaskType build() {
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder toBuilder() {
			LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTradeSettlementTaskTypeScheme()).ifPresent(builder::setTradeSettlementTaskTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradeSettlementTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradeSettlementTaskTypeScheme, _that.getTradeSettlementTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradeSettlementTaskTypeScheme != null ? tradeSettlementTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSettlementTaskType {" +
				"value=" + this.value + ", " +
				"tradeSettlementTaskTypeScheme=" + this.tradeSettlementTaskTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradeSettlementTaskType  ***********************/
	class LoanTradeSettlementTaskTypeBuilderImpl implements LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder {
	
		protected String value;
		protected String tradeSettlementTaskTypeScheme;
	
		public LoanTradeSettlementTaskTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradeSettlementTaskTypeScheme")
		public String getTradeSettlementTaskTypeScheme() {
			return tradeSettlementTaskTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("tradeSettlementTaskTypeScheme")
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder setTradeSettlementTaskTypeScheme(String tradeSettlementTaskTypeScheme) {
			this.tradeSettlementTaskTypeScheme = tradeSettlementTaskTypeScheme==null?null:tradeSettlementTaskTypeScheme;
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskType build() {
			return new LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeImpl(this);
		}
		
		@Override
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTradeSettlementTaskTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder o = (LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTradeSettlementTaskTypeScheme(), o.getTradeSettlementTaskTypeScheme(), this::setTradeSettlementTaskTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradeSettlementTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradeSettlementTaskTypeScheme, _that.getTradeSettlementTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradeSettlementTaskTypeScheme != null ? tradeSettlementTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSettlementTaskTypeBuilder {" +
				"value=" + this.value + ", " +
				"tradeSettlementTaskTypeScheme=" + this.tradeSettlementTaskTypeScheme +
			'}';
		}
	}
}
