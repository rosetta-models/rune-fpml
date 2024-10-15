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
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AccruingFeePayment;
import fpml.confirmation.AccruingPikPayment;
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import fpml.confirmation.LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder;
import fpml.confirmation.LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0BuilderImpl;
import fpml.confirmation.LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Impl;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.meta.LoanBulkServicingNotificationChoice0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LoanBulkServicingNotificationChoice0", builder=LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0BuilderImpl.class, version="${project.version}")
public interface LoanBulkServicingNotificationChoice0 extends RosettaModelObject {

	LoanBulkServicingNotificationChoice0Meta metaData = new LoanBulkServicingNotificationChoice0Meta();

	/*********************** Getter Methods  ***********************/
	NonRecurringFeePayment getFacilityFeePaymentGroup();
	AbstractFacilityEvent getFacilityEventGroup();
	AccruingFeePayment getAccruingFeePayment();
	AccruingPikPayment getAccruingPikPayment();
	AbstractLoanContractEvent getLoanContractEventGroup();
	AbstractLcEvent getLcEventGroup();

	/*********************** Build Methods  ***********************/
	LoanBulkServicingNotificationChoice0 build();
	
	LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder toBuilder();
	
	static LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder builder() {
		return new LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanBulkServicingNotificationChoice0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanBulkServicingNotificationChoice0> getType() {
		return LoanBulkServicingNotificationChoice0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityFeePaymentGroup"), processor, NonRecurringFeePayment.class, getFacilityFeePaymentGroup());
		processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.class, getFacilityEventGroup());
		processRosetta(path.newSubPath("accruingFeePayment"), processor, AccruingFeePayment.class, getAccruingFeePayment());
		processRosetta(path.newSubPath("accruingPikPayment"), processor, AccruingPikPayment.class, getAccruingPikPayment());
		processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanContractEvent.class, getLoanContractEventGroup());
		processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.class, getLcEventGroup());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBulkServicingNotificationChoice0Builder extends LoanBulkServicingNotificationChoice0, RosettaModelObjectBuilder {
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder getOrCreateFacilityFeePaymentGroup();
		NonRecurringFeePayment.NonRecurringFeePaymentBuilder getFacilityFeePaymentGroup();
		AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup();
		AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup();
		AccruingFeePayment.AccruingFeePaymentBuilder getOrCreateAccruingFeePayment();
		AccruingFeePayment.AccruingFeePaymentBuilder getAccruingFeePayment();
		AccruingPikPayment.AccruingPikPaymentBuilder getOrCreateAccruingPikPayment();
		AccruingPikPayment.AccruingPikPaymentBuilder getAccruingPikPayment();
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder getOrCreateLoanContractEventGroup();
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder getLoanContractEventGroup();
		AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup();
		AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup();
		LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setFacilityFeePaymentGroup(NonRecurringFeePayment facilityFeePaymentGroup);
		LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setFacilityEventGroup(AbstractFacilityEvent facilityEventGroup);
		LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setAccruingFeePayment(AccruingFeePayment accruingFeePayment);
		LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setAccruingPikPayment(AccruingPikPayment accruingPikPayment);
		LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setLoanContractEventGroup(AbstractLoanContractEvent loanContractEventGroup);
		LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setLcEventGroup(AbstractLcEvent lcEventGroup);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityFeePaymentGroup"), processor, NonRecurringFeePayment.NonRecurringFeePaymentBuilder.class, getFacilityFeePaymentGroup());
			processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.AbstractFacilityEventBuilder.class, getFacilityEventGroup());
			processRosetta(path.newSubPath("accruingFeePayment"), processor, AccruingFeePayment.AccruingFeePaymentBuilder.class, getAccruingFeePayment());
			processRosetta(path.newSubPath("accruingPikPayment"), processor, AccruingPikPayment.AccruingPikPaymentBuilder.class, getAccruingPikPayment());
			processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanContractEvent.AbstractLoanContractEventBuilder.class, getLoanContractEventGroup());
			processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.AbstractLcEventBuilder.class, getLcEventGroup());
		}
		

		LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder prune();
	}

	/*********************** Immutable Implementation of LoanBulkServicingNotificationChoice0  ***********************/
	class LoanBulkServicingNotificationChoice0Impl implements LoanBulkServicingNotificationChoice0 {
		private final NonRecurringFeePayment facilityFeePaymentGroup;
		private final AbstractFacilityEvent facilityEventGroup;
		private final AccruingFeePayment accruingFeePayment;
		private final AccruingPikPayment accruingPikPayment;
		private final AbstractLoanContractEvent loanContractEventGroup;
		private final AbstractLcEvent lcEventGroup;
		
		protected LoanBulkServicingNotificationChoice0Impl(LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder builder) {
			this.facilityFeePaymentGroup = ofNullable(builder.getFacilityFeePaymentGroup()).map(f->f.build()).orElse(null);
			this.facilityEventGroup = ofNullable(builder.getFacilityEventGroup()).map(f->f.build()).orElse(null);
			this.accruingFeePayment = ofNullable(builder.getAccruingFeePayment()).map(f->f.build()).orElse(null);
			this.accruingPikPayment = ofNullable(builder.getAccruingPikPayment()).map(f->f.build()).orElse(null);
			this.loanContractEventGroup = ofNullable(builder.getLoanContractEventGroup()).map(f->f.build()).orElse(null);
			this.lcEventGroup = ofNullable(builder.getLcEventGroup()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityFeePaymentGroup")
		public NonRecurringFeePayment getFacilityFeePaymentGroup() {
			return facilityFeePaymentGroup;
		}
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		public AbstractFacilityEvent getFacilityEventGroup() {
			return facilityEventGroup;
		}
		
		@Override
		@RosettaAttribute("accruingFeePayment")
		public AccruingFeePayment getAccruingFeePayment() {
			return accruingFeePayment;
		}
		
		@Override
		@RosettaAttribute("accruingPikPayment")
		public AccruingPikPayment getAccruingPikPayment() {
			return accruingPikPayment;
		}
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		public AbstractLoanContractEvent getLoanContractEventGroup() {
			return loanContractEventGroup;
		}
		
		@Override
		@RosettaAttribute("lcEventGroup")
		public AbstractLcEvent getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice0 build() {
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder toBuilder() {
			LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder builder) {
			ofNullable(getFacilityFeePaymentGroup()).ifPresent(builder::setFacilityFeePaymentGroup);
			ofNullable(getFacilityEventGroup()).ifPresent(builder::setFacilityEventGroup);
			ofNullable(getAccruingFeePayment()).ifPresent(builder::setAccruingFeePayment);
			ofNullable(getAccruingPikPayment()).ifPresent(builder::setAccruingPikPayment);
			ofNullable(getLoanContractEventGroup()).ifPresent(builder::setLoanContractEventGroup);
			ofNullable(getLcEventGroup()).ifPresent(builder::setLcEventGroup);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(facilityFeePaymentGroup, _that.getFacilityFeePaymentGroup())) return false;
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(accruingFeePayment, _that.getAccruingFeePayment())) return false;
			if (!Objects.equals(accruingPikPayment, _that.getAccruingPikPayment())) return false;
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityFeePaymentGroup != null ? facilityFeePaymentGroup.hashCode() : 0);
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (accruingFeePayment != null ? accruingFeePayment.hashCode() : 0);
			_result = 31 * _result + (accruingPikPayment != null ? accruingPikPayment.hashCode() : 0);
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationChoice0 {" +
				"facilityFeePaymentGroup=" + this.facilityFeePaymentGroup + ", " +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"accruingFeePayment=" + this.accruingFeePayment + ", " +
				"accruingPikPayment=" + this.accruingPikPayment + ", " +
				"loanContractEventGroup=" + this.loanContractEventGroup + ", " +
				"lcEventGroup=" + this.lcEventGroup +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanBulkServicingNotificationChoice0  ***********************/
	class LoanBulkServicingNotificationChoice0BuilderImpl implements LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder {
	
		protected NonRecurringFeePayment.NonRecurringFeePaymentBuilder facilityFeePaymentGroup;
		protected AbstractFacilityEvent.AbstractFacilityEventBuilder facilityEventGroup;
		protected AccruingFeePayment.AccruingFeePaymentBuilder accruingFeePayment;
		protected AccruingPikPayment.AccruingPikPaymentBuilder accruingPikPayment;
		protected AbstractLoanContractEvent.AbstractLoanContractEventBuilder loanContractEventGroup;
		protected AbstractLcEvent.AbstractLcEventBuilder lcEventGroup;
	
		public LoanBulkServicingNotificationChoice0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityFeePaymentGroup")
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder getFacilityFeePaymentGroup() {
			return facilityFeePaymentGroup;
		}
		
		@Override
		public NonRecurringFeePayment.NonRecurringFeePaymentBuilder getOrCreateFacilityFeePaymentGroup() {
			NonRecurringFeePayment.NonRecurringFeePaymentBuilder result;
			if (facilityFeePaymentGroup!=null) {
				result = facilityFeePaymentGroup;
			}
			else {
				result = facilityFeePaymentGroup = NonRecurringFeePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup() {
			return facilityEventGroup;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup() {
			AbstractFacilityEvent.AbstractFacilityEventBuilder result;
			if (facilityEventGroup!=null) {
				result = facilityEventGroup;
			}
			else {
				result = facilityEventGroup = AbstractFacilityEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruingFeePayment")
		public AccruingFeePayment.AccruingFeePaymentBuilder getAccruingFeePayment() {
			return accruingFeePayment;
		}
		
		@Override
		public AccruingFeePayment.AccruingFeePaymentBuilder getOrCreateAccruingFeePayment() {
			AccruingFeePayment.AccruingFeePaymentBuilder result;
			if (accruingFeePayment!=null) {
				result = accruingFeePayment;
			}
			else {
				result = accruingFeePayment = AccruingFeePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruingPikPayment")
		public AccruingPikPayment.AccruingPikPaymentBuilder getAccruingPikPayment() {
			return accruingPikPayment;
		}
		
		@Override
		public AccruingPikPayment.AccruingPikPaymentBuilder getOrCreateAccruingPikPayment() {
			AccruingPikPayment.AccruingPikPaymentBuilder result;
			if (accruingPikPayment!=null) {
				result = accruingPikPayment;
			}
			else {
				result = accruingPikPayment = AccruingPikPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder getLoanContractEventGroup() {
			return loanContractEventGroup;
		}
		
		@Override
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder getOrCreateLoanContractEventGroup() {
			AbstractLoanContractEvent.AbstractLoanContractEventBuilder result;
			if (loanContractEventGroup!=null) {
				result = loanContractEventGroup;
			}
			else {
				result = loanContractEventGroup = AbstractLoanContractEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcEventGroup")
		public AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup() {
			AbstractLcEvent.AbstractLcEventBuilder result;
			if (lcEventGroup!=null) {
				result = lcEventGroup;
			}
			else {
				result = lcEventGroup = AbstractLcEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityFeePaymentGroup")
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setFacilityFeePaymentGroup(NonRecurringFeePayment facilityFeePaymentGroup) {
			this.facilityFeePaymentGroup = facilityFeePaymentGroup==null?null:facilityFeePaymentGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityEventGroup")
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setFacilityEventGroup(AbstractFacilityEvent facilityEventGroup) {
			this.facilityEventGroup = facilityEventGroup==null?null:facilityEventGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingFeePayment")
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setAccruingFeePayment(AccruingFeePayment accruingFeePayment) {
			this.accruingFeePayment = accruingFeePayment==null?null:accruingFeePayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingPikPayment")
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setAccruingPikPayment(AccruingPikPayment accruingPikPayment) {
			this.accruingPikPayment = accruingPikPayment==null?null:accruingPikPayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractEventGroup")
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setLoanContractEventGroup(AbstractLoanContractEvent loanContractEventGroup) {
			this.loanContractEventGroup = loanContractEventGroup==null?null:loanContractEventGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lcEventGroup")
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder setLcEventGroup(AbstractLcEvent lcEventGroup) {
			this.lcEventGroup = lcEventGroup==null?null:lcEventGroup.toBuilder();
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice0 build() {
			return new LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Impl(this);
		}
		
		@Override
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder prune() {
			if (facilityFeePaymentGroup!=null && !facilityFeePaymentGroup.prune().hasData()) facilityFeePaymentGroup = null;
			if (facilityEventGroup!=null && !facilityEventGroup.prune().hasData()) facilityEventGroup = null;
			if (accruingFeePayment!=null && !accruingFeePayment.prune().hasData()) accruingFeePayment = null;
			if (accruingPikPayment!=null && !accruingPikPayment.prune().hasData()) accruingPikPayment = null;
			if (loanContractEventGroup!=null && !loanContractEventGroup.prune().hasData()) loanContractEventGroup = null;
			if (lcEventGroup!=null && !lcEventGroup.prune().hasData()) lcEventGroup = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityFeePaymentGroup()!=null && getFacilityFeePaymentGroup().hasData()) return true;
			if (getFacilityEventGroup()!=null && getFacilityEventGroup().hasData()) return true;
			if (getAccruingFeePayment()!=null && getAccruingFeePayment().hasData()) return true;
			if (getAccruingPikPayment()!=null && getAccruingPikPayment().hasData()) return true;
			if (getLoanContractEventGroup()!=null && getLoanContractEventGroup().hasData()) return true;
			if (getLcEventGroup()!=null && getLcEventGroup().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder o = (LoanBulkServicingNotificationChoice0.LoanBulkServicingNotificationChoice0Builder) other;
			
			merger.mergeRosetta(getFacilityFeePaymentGroup(), o.getFacilityFeePaymentGroup(), this::setFacilityFeePaymentGroup);
			merger.mergeRosetta(getFacilityEventGroup(), o.getFacilityEventGroup(), this::setFacilityEventGroup);
			merger.mergeRosetta(getAccruingFeePayment(), o.getAccruingFeePayment(), this::setAccruingFeePayment);
			merger.mergeRosetta(getAccruingPikPayment(), o.getAccruingPikPayment(), this::setAccruingPikPayment);
			merger.mergeRosetta(getLoanContractEventGroup(), o.getLoanContractEventGroup(), this::setLoanContractEventGroup);
			merger.mergeRosetta(getLcEventGroup(), o.getLcEventGroup(), this::setLcEventGroup);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(facilityFeePaymentGroup, _that.getFacilityFeePaymentGroup())) return false;
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(accruingFeePayment, _that.getAccruingFeePayment())) return false;
			if (!Objects.equals(accruingPikPayment, _that.getAccruingPikPayment())) return false;
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityFeePaymentGroup != null ? facilityFeePaymentGroup.hashCode() : 0);
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (accruingFeePayment != null ? accruingFeePayment.hashCode() : 0);
			_result = 31 * _result + (accruingPikPayment != null ? accruingPikPayment.hashCode() : 0);
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationChoice0Builder {" +
				"facilityFeePaymentGroup=" + this.facilityFeePaymentGroup + ", " +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"accruingFeePayment=" + this.accruingFeePayment + ", " +
				"accruingPikPayment=" + this.accruingPikPayment + ", " +
				"loanContractEventGroup=" + this.loanContractEventGroup + ", " +
				"lcEventGroup=" + this.lcEventGroup +
			'}';
		}
	}
}
