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
import fpml.confirmation.SettlementInstructionId;
import fpml.confirmation.SettlementInstructionId.SettlementInstructionIdBuilder;
import fpml.confirmation.SettlementInstructionId.SettlementInstructionIdBuilderImpl;
import fpml.confirmation.SettlementInstructionId.SettlementInstructionIdImpl;
import fpml.confirmation.meta.SettlementInstructionIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a cash settlement details identifier and qualifying scheme
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SettlementInstructionId", builder=SettlementInstructionId.SettlementInstructionIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SettlementInstructionId extends RosettaModelObject {

	SettlementInstructionIdMeta metaData = new SettlementInstructionIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getSettlementInstructionIdScheme();

	/*********************** Build Methods  ***********************/
	SettlementInstructionId build();
	
	SettlementInstructionId.SettlementInstructionIdBuilder toBuilder();
	
	static SettlementInstructionId.SettlementInstructionIdBuilder builder() {
		return new SettlementInstructionId.SettlementInstructionIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementInstructionId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementInstructionId> getType() {
		return SettlementInstructionId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("settlementInstructionIdScheme"), String.class, getSettlementInstructionIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementInstructionIdBuilder extends SettlementInstructionId, RosettaModelObjectBuilder {
		SettlementInstructionId.SettlementInstructionIdBuilder setValue(String value);
		SettlementInstructionId.SettlementInstructionIdBuilder setSettlementInstructionIdScheme(String settlementInstructionIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("settlementInstructionIdScheme"), String.class, getSettlementInstructionIdScheme(), this);
		}
		

		SettlementInstructionId.SettlementInstructionIdBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementInstructionId  ***********************/
	class SettlementInstructionIdImpl implements SettlementInstructionId {
		private final String value;
		private final String settlementInstructionIdScheme;
		
		protected SettlementInstructionIdImpl(SettlementInstructionId.SettlementInstructionIdBuilder builder) {
			this.value = builder.getValue();
			this.settlementInstructionIdScheme = builder.getSettlementInstructionIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settlementInstructionIdScheme")
		public String getSettlementInstructionIdScheme() {
			return settlementInstructionIdScheme;
		}
		
		@Override
		public SettlementInstructionId build() {
			return this;
		}
		
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder toBuilder() {
			SettlementInstructionId.SettlementInstructionIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementInstructionId.SettlementInstructionIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSettlementInstructionIdScheme()).ifPresent(builder::setSettlementInstructionIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInstructionId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementInstructionIdScheme, _that.getSettlementInstructionIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementInstructionIdScheme != null ? settlementInstructionIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInstructionId {" +
				"value=" + this.value + ", " +
				"settlementInstructionIdScheme=" + this.settlementInstructionIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementInstructionId  ***********************/
	class SettlementInstructionIdBuilderImpl implements SettlementInstructionId.SettlementInstructionIdBuilder {
	
		protected String value;
		protected String settlementInstructionIdScheme;
	
		public SettlementInstructionIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settlementInstructionIdScheme")
		public String getSettlementInstructionIdScheme() {
			return settlementInstructionIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public SettlementInstructionId.SettlementInstructionIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("settlementInstructionIdScheme")
		public SettlementInstructionId.SettlementInstructionIdBuilder setSettlementInstructionIdScheme(String settlementInstructionIdScheme) {
			this.settlementInstructionIdScheme = settlementInstructionIdScheme==null?null:settlementInstructionIdScheme;
			return this;
		}
		
		@Override
		public SettlementInstructionId build() {
			return new SettlementInstructionId.SettlementInstructionIdImpl(this);
		}
		
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSettlementInstructionIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementInstructionId.SettlementInstructionIdBuilder o = (SettlementInstructionId.SettlementInstructionIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSettlementInstructionIdScheme(), o.getSettlementInstructionIdScheme(), this::setSettlementInstructionIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInstructionId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementInstructionIdScheme, _that.getSettlementInstructionIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementInstructionIdScheme != null ? settlementInstructionIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInstructionIdBuilder {" +
				"value=" + this.value + ", " +
				"settlementInstructionIdScheme=" + this.settlementInstructionIdScheme +
			'}';
		}
	}
}
