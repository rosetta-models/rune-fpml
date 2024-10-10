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
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.AdjustmentType.AdjustmentTypeBuilder;
import fpml.confirmation.AdjustmentType.AdjustmentTypeBuilderImpl;
import fpml.confirmation.AdjustmentType.AdjustmentTypeImpl;
import fpml.confirmation.AmountAdjustmentEnum;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.AdjustmentTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure used to describe an adjustment.
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustmentType", builder=AdjustmentType.AdjustmentTypeBuilderImpl.class, version="${project.version}")
public interface AdjustmentType extends RosettaModelObject {

	AdjustmentTypeMeta metaData = new AdjustmentTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the type of adjustment applied - increase or decrease.
	 */
	AmountAdjustmentEnum getAdjustmentType();
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	AdjustmentType build();
	
	AdjustmentType.AdjustmentTypeBuilder toBuilder();
	
	static AdjustmentType.AdjustmentTypeBuilder builder() {
		return new AdjustmentType.AdjustmentTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustmentType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustmentType> getType() {
		return AdjustmentType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustmentType"), AmountAdjustmentEnum.class, getAdjustmentType(), this);
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustmentTypeBuilder extends AdjustmentType, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		AdjustmentType.AdjustmentTypeBuilder setAdjustmentType(AmountAdjustmentEnum adjustmentType);
		AdjustmentType.AdjustmentTypeBuilder setAmount(MoneyWithParticipantShare amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustmentType"), AmountAdjustmentEnum.class, getAdjustmentType(), this);
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		AdjustmentType.AdjustmentTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustmentType  ***********************/
	class AdjustmentTypeImpl implements AdjustmentType {
		private final AmountAdjustmentEnum adjustmentType;
		private final MoneyWithParticipantShare amount;
		
		protected AdjustmentTypeImpl(AdjustmentType.AdjustmentTypeBuilder builder) {
			this.adjustmentType = builder.getAdjustmentType();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustmentType")
		public AmountAdjustmentEnum getAdjustmentType() {
			return adjustmentType;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		public AdjustmentType build() {
			return this;
		}
		
		@Override
		public AdjustmentType.AdjustmentTypeBuilder toBuilder() {
			AdjustmentType.AdjustmentTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustmentType.AdjustmentTypeBuilder builder) {
			ofNullable(getAdjustmentType()).ifPresent(builder::setAdjustmentType);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustmentType _that = getType().cast(o);
		
			if (!Objects.equals(adjustmentType, _that.getAdjustmentType())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustmentType != null ? adjustmentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustmentType {" +
				"adjustmentType=" + this.adjustmentType + ", " +
				"amount=" + this.amount +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustmentType  ***********************/
	class AdjustmentTypeBuilderImpl implements AdjustmentType.AdjustmentTypeBuilder {
	
		protected AmountAdjustmentEnum adjustmentType;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
	
		public AdjustmentTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustmentType")
		public AmountAdjustmentEnum getAdjustmentType() {
			return adjustmentType;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustmentType")
		public AdjustmentType.AdjustmentTypeBuilder setAdjustmentType(AmountAdjustmentEnum adjustmentType) {
			this.adjustmentType = adjustmentType==null?null:adjustmentType;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public AdjustmentType.AdjustmentTypeBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public AdjustmentType build() {
			return new AdjustmentType.AdjustmentTypeImpl(this);
		}
		
		@Override
		public AdjustmentType.AdjustmentTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustmentType.AdjustmentTypeBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustmentType()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustmentType.AdjustmentTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustmentType.AdjustmentTypeBuilder o = (AdjustmentType.AdjustmentTypeBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getAdjustmentType(), o.getAdjustmentType(), this::setAdjustmentType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustmentType _that = getType().cast(o);
		
			if (!Objects.equals(adjustmentType, _that.getAdjustmentType())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustmentType != null ? adjustmentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustmentTypeBuilder {" +
				"adjustmentType=" + this.adjustmentType + ", " +
				"amount=" + this.amount +
			'}';
		}
	}
}
