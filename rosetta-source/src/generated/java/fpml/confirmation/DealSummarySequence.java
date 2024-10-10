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
import fpml.confirmation.DealSummarySequence;
import fpml.confirmation.DealSummarySequence.DealSummarySequenceBuilder;
import fpml.confirmation.DealSummarySequence.DealSummarySequenceBuilderImpl;
import fpml.confirmation.DealSummarySequence.DealSummarySequenceImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.DealSummarySequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DealSummarySequence", builder=DealSummarySequence.DealSummarySequenceBuilderImpl.class, version="${project.version}")
public interface DealSummarySequence extends RosettaModelObject {

	DealSummarySequenceMeta metaData = new DealSummarySequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Original deal amount.
	 */
	NonNegativeMoney getIssuedAmount();
	/**
	 * Current deal amount.
	 */
	MoneyWithParticipantShare getCurrentDealAmount();

	/*********************** Build Methods  ***********************/
	DealSummarySequence build();
	
	DealSummarySequence.DealSummarySequenceBuilder toBuilder();
	
	static DealSummarySequence.DealSummarySequenceBuilder builder() {
		return new DealSummarySequence.DealSummarySequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealSummarySequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DealSummarySequence> getType() {
		return DealSummarySequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuedAmount"), processor, NonNegativeMoney.class, getIssuedAmount());
		processRosetta(path.newSubPath("currentDealAmount"), processor, MoneyWithParticipantShare.class, getCurrentDealAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealSummarySequenceBuilder extends DealSummarySequence, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateIssuedAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getIssuedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateCurrentDealAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getCurrentDealAmount();
		DealSummarySequence.DealSummarySequenceBuilder setIssuedAmount(NonNegativeMoney issuedAmount);
		DealSummarySequence.DealSummarySequenceBuilder setCurrentDealAmount(MoneyWithParticipantShare currentDealAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuedAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getIssuedAmount());
			processRosetta(path.newSubPath("currentDealAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getCurrentDealAmount());
		}
		

		DealSummarySequence.DealSummarySequenceBuilder prune();
	}

	/*********************** Immutable Implementation of DealSummarySequence  ***********************/
	class DealSummarySequenceImpl implements DealSummarySequence {
		private final NonNegativeMoney issuedAmount;
		private final MoneyWithParticipantShare currentDealAmount;
		
		protected DealSummarySequenceImpl(DealSummarySequence.DealSummarySequenceBuilder builder) {
			this.issuedAmount = ofNullable(builder.getIssuedAmount()).map(f->f.build()).orElse(null);
			this.currentDealAmount = ofNullable(builder.getCurrentDealAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("issuedAmount")
		public NonNegativeMoney getIssuedAmount() {
			return issuedAmount;
		}
		
		@Override
		@RosettaAttribute("currentDealAmount")
		public MoneyWithParticipantShare getCurrentDealAmount() {
			return currentDealAmount;
		}
		
		@Override
		public DealSummarySequence build() {
			return this;
		}
		
		@Override
		public DealSummarySequence.DealSummarySequenceBuilder toBuilder() {
			DealSummarySequence.DealSummarySequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealSummarySequence.DealSummarySequenceBuilder builder) {
			ofNullable(getIssuedAmount()).ifPresent(builder::setIssuedAmount);
			ofNullable(getCurrentDealAmount()).ifPresent(builder::setCurrentDealAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealSummarySequence _that = getType().cast(o);
		
			if (!Objects.equals(issuedAmount, _that.getIssuedAmount())) return false;
			if (!Objects.equals(currentDealAmount, _that.getCurrentDealAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuedAmount != null ? issuedAmount.hashCode() : 0);
			_result = 31 * _result + (currentDealAmount != null ? currentDealAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealSummarySequence {" +
				"issuedAmount=" + this.issuedAmount + ", " +
				"currentDealAmount=" + this.currentDealAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of DealSummarySequence  ***********************/
	class DealSummarySequenceBuilderImpl implements DealSummarySequence.DealSummarySequenceBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder issuedAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder currentDealAmount;
	
		public DealSummarySequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("issuedAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getIssuedAmount() {
			return issuedAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateIssuedAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (issuedAmount!=null) {
				result = issuedAmount;
			}
			else {
				result = issuedAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currentDealAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getCurrentDealAmount() {
			return currentDealAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateCurrentDealAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (currentDealAmount!=null) {
				result = currentDealAmount;
			}
			else {
				result = currentDealAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuedAmount")
		public DealSummarySequence.DealSummarySequenceBuilder setIssuedAmount(NonNegativeMoney issuedAmount) {
			this.issuedAmount = issuedAmount==null?null:issuedAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currentDealAmount")
		public DealSummarySequence.DealSummarySequenceBuilder setCurrentDealAmount(MoneyWithParticipantShare currentDealAmount) {
			this.currentDealAmount = currentDealAmount==null?null:currentDealAmount.toBuilder();
			return this;
		}
		
		@Override
		public DealSummarySequence build() {
			return new DealSummarySequence.DealSummarySequenceImpl(this);
		}
		
		@Override
		public DealSummarySequence.DealSummarySequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealSummarySequence.DealSummarySequenceBuilder prune() {
			if (issuedAmount!=null && !issuedAmount.prune().hasData()) issuedAmount = null;
			if (currentDealAmount!=null && !currentDealAmount.prune().hasData()) currentDealAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuedAmount()!=null && getIssuedAmount().hasData()) return true;
			if (getCurrentDealAmount()!=null && getCurrentDealAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealSummarySequence.DealSummarySequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DealSummarySequence.DealSummarySequenceBuilder o = (DealSummarySequence.DealSummarySequenceBuilder) other;
			
			merger.mergeRosetta(getIssuedAmount(), o.getIssuedAmount(), this::setIssuedAmount);
			merger.mergeRosetta(getCurrentDealAmount(), o.getCurrentDealAmount(), this::setCurrentDealAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealSummarySequence _that = getType().cast(o);
		
			if (!Objects.equals(issuedAmount, _that.getIssuedAmount())) return false;
			if (!Objects.equals(currentDealAmount, _that.getCurrentDealAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuedAmount != null ? issuedAmount.hashCode() : 0);
			_result = 31 * _result + (currentDealAmount != null ? currentDealAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealSummarySequenceBuilder {" +
				"issuedAmount=" + this.issuedAmount + ", " +
				"currentDealAmount=" + this.currentDealAmount +
			'}';
		}
	}
}
