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
import fpml.confirmation.UtilizationModelSequence0;
import fpml.confirmation.UtilizationModelSequence0.UtilizationModelSequence0Builder;
import fpml.confirmation.UtilizationModelSequence0.UtilizationModelSequence0BuilderImpl;
import fpml.confirmation.UtilizationModelSequence0.UtilizationModelSequence0Impl;
import fpml.confirmation.meta.UtilizationModelSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="UtilizationModelSequence0", builder=UtilizationModelSequence0.UtilizationModelSequence0BuilderImpl.class, version="${project.version}")
public interface UtilizationModelSequence0 extends RosettaModelObject {

	UtilizationModelSequence0Meta metaData = new UtilizationModelSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount of utilization which is funded.
	 */
	MoneyWithParticipantShare getFundedUtilizedAmount();
	/**
	 * The amount of utilization which is unfunded.
	 */
	MoneyWithParticipantShare getUnfundedUtilizedAmount();

	/*********************** Build Methods  ***********************/
	UtilizationModelSequence0 build();
	
	UtilizationModelSequence0.UtilizationModelSequence0Builder toBuilder();
	
	static UtilizationModelSequence0.UtilizationModelSequence0Builder builder() {
		return new UtilizationModelSequence0.UtilizationModelSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UtilizationModelSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UtilizationModelSequence0> getType() {
		return UtilizationModelSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fundedUtilizedAmount"), processor, MoneyWithParticipantShare.class, getFundedUtilizedAmount());
		processRosetta(path.newSubPath("unfundedUtilizedAmount"), processor, MoneyWithParticipantShare.class, getUnfundedUtilizedAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UtilizationModelSequence0Builder extends UtilizationModelSequence0, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateFundedUtilizedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getFundedUtilizedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnfundedUtilizedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnfundedUtilizedAmount();
		UtilizationModelSequence0.UtilizationModelSequence0Builder setFundedUtilizedAmount(MoneyWithParticipantShare fundedUtilizedAmount);
		UtilizationModelSequence0.UtilizationModelSequence0Builder setUnfundedUtilizedAmount(MoneyWithParticipantShare unfundedUtilizedAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fundedUtilizedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getFundedUtilizedAmount());
			processRosetta(path.newSubPath("unfundedUtilizedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getUnfundedUtilizedAmount());
		}
		

		UtilizationModelSequence0.UtilizationModelSequence0Builder prune();
	}

	/*********************** Immutable Implementation of UtilizationModelSequence0  ***********************/
	class UtilizationModelSequence0Impl implements UtilizationModelSequence0 {
		private final MoneyWithParticipantShare fundedUtilizedAmount;
		private final MoneyWithParticipantShare unfundedUtilizedAmount;
		
		protected UtilizationModelSequence0Impl(UtilizationModelSequence0.UtilizationModelSequence0Builder builder) {
			this.fundedUtilizedAmount = ofNullable(builder.getFundedUtilizedAmount()).map(f->f.build()).orElse(null);
			this.unfundedUtilizedAmount = ofNullable(builder.getUnfundedUtilizedAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fundedUtilizedAmount")
		public MoneyWithParticipantShare getFundedUtilizedAmount() {
			return fundedUtilizedAmount;
		}
		
		@Override
		@RosettaAttribute("unfundedUtilizedAmount")
		public MoneyWithParticipantShare getUnfundedUtilizedAmount() {
			return unfundedUtilizedAmount;
		}
		
		@Override
		public UtilizationModelSequence0 build() {
			return this;
		}
		
		@Override
		public UtilizationModelSequence0.UtilizationModelSequence0Builder toBuilder() {
			UtilizationModelSequence0.UtilizationModelSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UtilizationModelSequence0.UtilizationModelSequence0Builder builder) {
			ofNullable(getFundedUtilizedAmount()).ifPresent(builder::setFundedUtilizedAmount);
			ofNullable(getUnfundedUtilizedAmount()).ifPresent(builder::setUnfundedUtilizedAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationModelSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(fundedUtilizedAmount, _that.getFundedUtilizedAmount())) return false;
			if (!Objects.equals(unfundedUtilizedAmount, _that.getUnfundedUtilizedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fundedUtilizedAmount != null ? fundedUtilizedAmount.hashCode() : 0);
			_result = 31 * _result + (unfundedUtilizedAmount != null ? unfundedUtilizedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationModelSequence0 {" +
				"fundedUtilizedAmount=" + this.fundedUtilizedAmount + ", " +
				"unfundedUtilizedAmount=" + this.unfundedUtilizedAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of UtilizationModelSequence0  ***********************/
	class UtilizationModelSequence0BuilderImpl implements UtilizationModelSequence0.UtilizationModelSequence0Builder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder fundedUtilizedAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder unfundedUtilizedAmount;
	
		public UtilizationModelSequence0BuilderImpl() {
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
		public UtilizationModelSequence0.UtilizationModelSequence0Builder setFundedUtilizedAmount(MoneyWithParticipantShare fundedUtilizedAmount) {
			this.fundedUtilizedAmount = fundedUtilizedAmount==null?null:fundedUtilizedAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("unfundedUtilizedAmount")
		public UtilizationModelSequence0.UtilizationModelSequence0Builder setUnfundedUtilizedAmount(MoneyWithParticipantShare unfundedUtilizedAmount) {
			this.unfundedUtilizedAmount = unfundedUtilizedAmount==null?null:unfundedUtilizedAmount.toBuilder();
			return this;
		}
		
		@Override
		public UtilizationModelSequence0 build() {
			return new UtilizationModelSequence0.UtilizationModelSequence0Impl(this);
		}
		
		@Override
		public UtilizationModelSequence0.UtilizationModelSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationModelSequence0.UtilizationModelSequence0Builder prune() {
			if (fundedUtilizedAmount!=null && !fundedUtilizedAmount.prune().hasData()) fundedUtilizedAmount = null;
			if (unfundedUtilizedAmount!=null && !unfundedUtilizedAmount.prune().hasData()) unfundedUtilizedAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFundedUtilizedAmount()!=null && getFundedUtilizedAmount().hasData()) return true;
			if (getUnfundedUtilizedAmount()!=null && getUnfundedUtilizedAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationModelSequence0.UtilizationModelSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UtilizationModelSequence0.UtilizationModelSequence0Builder o = (UtilizationModelSequence0.UtilizationModelSequence0Builder) other;
			
			merger.mergeRosetta(getFundedUtilizedAmount(), o.getFundedUtilizedAmount(), this::setFundedUtilizedAmount);
			merger.mergeRosetta(getUnfundedUtilizedAmount(), o.getUnfundedUtilizedAmount(), this::setUnfundedUtilizedAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationModelSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(fundedUtilizedAmount, _that.getFundedUtilizedAmount())) return false;
			if (!Objects.equals(unfundedUtilizedAmount, _that.getUnfundedUtilizedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fundedUtilizedAmount != null ? fundedUtilizedAmount.hashCode() : 0);
			_result = 31 * _result + (unfundedUtilizedAmount != null ? unfundedUtilizedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationModelSequence0Builder {" +
				"fundedUtilizedAmount=" + this.fundedUtilizedAmount + ", " +
				"unfundedUtilizedAmount=" + this.unfundedUtilizedAmount +
			'}';
		}
	}
}
