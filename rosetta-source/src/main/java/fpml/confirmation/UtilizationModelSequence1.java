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
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.UtilizationModelSequence1;
import fpml.confirmation.UtilizationModelSequence1.UtilizationModelSequence1Builder;
import fpml.confirmation.UtilizationModelSequence1.UtilizationModelSequence1BuilderImpl;
import fpml.confirmation.UtilizationModelSequence1.UtilizationModelSequence1Impl;
import fpml.confirmation.meta.UtilizationModelSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="UtilizationModelSequence1", builder=UtilizationModelSequence1.UtilizationModelSequence1BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface UtilizationModelSequence1 extends RosettaModelObject {

	UtilizationModelSequence1Meta metaData = new UtilizationModelSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount of utilization which is unfunded.
	 */
	MoneyWithParticipantShare getUnfundedUtilizedAmount();
	/**
	 * The amount of utilization which is funded.
	 */
	MoneyWithParticipantShare getFundedUtilizedAmount();

	/*********************** Build Methods  ***********************/
	UtilizationModelSequence1 build();
	
	UtilizationModelSequence1.UtilizationModelSequence1Builder toBuilder();
	
	static UtilizationModelSequence1.UtilizationModelSequence1Builder builder() {
		return new UtilizationModelSequence1.UtilizationModelSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UtilizationModelSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UtilizationModelSequence1> getType() {
		return UtilizationModelSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unfundedUtilizedAmount"), processor, MoneyWithParticipantShare.class, getUnfundedUtilizedAmount());
		processRosetta(path.newSubPath("fundedUtilizedAmount"), processor, MoneyWithParticipantShare.class, getFundedUtilizedAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UtilizationModelSequence1Builder extends UtilizationModelSequence1, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnfundedUtilizedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnfundedUtilizedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateFundedUtilizedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getFundedUtilizedAmount();
		UtilizationModelSequence1.UtilizationModelSequence1Builder setUnfundedUtilizedAmount(MoneyWithParticipantShare unfundedUtilizedAmount);
		UtilizationModelSequence1.UtilizationModelSequence1Builder setFundedUtilizedAmount(MoneyWithParticipantShare fundedUtilizedAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unfundedUtilizedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getUnfundedUtilizedAmount());
			processRosetta(path.newSubPath("fundedUtilizedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getFundedUtilizedAmount());
		}
		

		UtilizationModelSequence1.UtilizationModelSequence1Builder prune();
	}

	/*********************** Immutable Implementation of UtilizationModelSequence1  ***********************/
	class UtilizationModelSequence1Impl implements UtilizationModelSequence1 {
		private final MoneyWithParticipantShare unfundedUtilizedAmount;
		private final MoneyWithParticipantShare fundedUtilizedAmount;
		
		protected UtilizationModelSequence1Impl(UtilizationModelSequence1.UtilizationModelSequence1Builder builder) {
			this.unfundedUtilizedAmount = ofNullable(builder.getUnfundedUtilizedAmount()).map(f->f.build()).orElse(null);
			this.fundedUtilizedAmount = ofNullable(builder.getFundedUtilizedAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("unfundedUtilizedAmount")
		public MoneyWithParticipantShare getUnfundedUtilizedAmount() {
			return unfundedUtilizedAmount;
		}
		
		@Override
		@RosettaAttribute("fundedUtilizedAmount")
		public MoneyWithParticipantShare getFundedUtilizedAmount() {
			return fundedUtilizedAmount;
		}
		
		@Override
		public UtilizationModelSequence1 build() {
			return this;
		}
		
		@Override
		public UtilizationModelSequence1.UtilizationModelSequence1Builder toBuilder() {
			UtilizationModelSequence1.UtilizationModelSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UtilizationModelSequence1.UtilizationModelSequence1Builder builder) {
			ofNullable(getUnfundedUtilizedAmount()).ifPresent(builder::setUnfundedUtilizedAmount);
			ofNullable(getFundedUtilizedAmount()).ifPresent(builder::setFundedUtilizedAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(unfundedUtilizedAmount, _that.getUnfundedUtilizedAmount())) return false;
			if (!Objects.equals(fundedUtilizedAmount, _that.getFundedUtilizedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unfundedUtilizedAmount != null ? unfundedUtilizedAmount.hashCode() : 0);
			_result = 31 * _result + (fundedUtilizedAmount != null ? fundedUtilizedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationModelSequence1 {" +
				"unfundedUtilizedAmount=" + this.unfundedUtilizedAmount + ", " +
				"fundedUtilizedAmount=" + this.fundedUtilizedAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of UtilizationModelSequence1  ***********************/
	class UtilizationModelSequence1BuilderImpl implements UtilizationModelSequence1.UtilizationModelSequence1Builder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder unfundedUtilizedAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder fundedUtilizedAmount;
	
		public UtilizationModelSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("unfundedUtilizedAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnfundedUtilizedAmount() {
			return unfundedUtilizedAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnfundedUtilizedAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (unfundedUtilizedAmount!=null) {
				result = unfundedUtilizedAmount;
			}
			else {
				result = unfundedUtilizedAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fundedUtilizedAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getFundedUtilizedAmount() {
			return fundedUtilizedAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateFundedUtilizedAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (fundedUtilizedAmount!=null) {
				result = fundedUtilizedAmount;
			}
			else {
				result = fundedUtilizedAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unfundedUtilizedAmount")
		public UtilizationModelSequence1.UtilizationModelSequence1Builder setUnfundedUtilizedAmount(MoneyWithParticipantShare unfundedUtilizedAmount) {
			this.unfundedUtilizedAmount = unfundedUtilizedAmount==null?null:unfundedUtilizedAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fundedUtilizedAmount")
		public UtilizationModelSequence1.UtilizationModelSequence1Builder setFundedUtilizedAmount(MoneyWithParticipantShare fundedUtilizedAmount) {
			this.fundedUtilizedAmount = fundedUtilizedAmount==null?null:fundedUtilizedAmount.toBuilder();
			return this;
		}
		
		@Override
		public UtilizationModelSequence1 build() {
			return new UtilizationModelSequence1.UtilizationModelSequence1Impl(this);
		}
		
		@Override
		public UtilizationModelSequence1.UtilizationModelSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationModelSequence1.UtilizationModelSequence1Builder prune() {
			if (unfundedUtilizedAmount!=null && !unfundedUtilizedAmount.prune().hasData()) unfundedUtilizedAmount = null;
			if (fundedUtilizedAmount!=null && !fundedUtilizedAmount.prune().hasData()) fundedUtilizedAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnfundedUtilizedAmount()!=null && getUnfundedUtilizedAmount().hasData()) return true;
			if (getFundedUtilizedAmount()!=null && getFundedUtilizedAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationModelSequence1.UtilizationModelSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UtilizationModelSequence1.UtilizationModelSequence1Builder o = (UtilizationModelSequence1.UtilizationModelSequence1Builder) other;
			
			merger.mergeRosetta(getUnfundedUtilizedAmount(), o.getUnfundedUtilizedAmount(), this::setUnfundedUtilizedAmount);
			merger.mergeRosetta(getFundedUtilizedAmount(), o.getFundedUtilizedAmount(), this::setFundedUtilizedAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(unfundedUtilizedAmount, _that.getUnfundedUtilizedAmount())) return false;
			if (!Objects.equals(fundedUtilizedAmount, _that.getFundedUtilizedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unfundedUtilizedAmount != null ? unfundedUtilizedAmount.hashCode() : 0);
			_result = 31 * _result + (fundedUtilizedAmount != null ? fundedUtilizedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationModelSequence1Builder {" +
				"unfundedUtilizedAmount=" + this.unfundedUtilizedAmount + ", " +
				"fundedUtilizedAmount=" + this.fundedUtilizedAmount +
			'}';
		}
	}
}
