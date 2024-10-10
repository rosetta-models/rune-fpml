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
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.ExerciseSideEnum;
import fpml.confirmation.NoTouchRateObservationSequence1;
import fpml.confirmation.NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder;
import fpml.confirmation.NoTouchRateObservationSequence1.NoTouchRateObservationSequence1BuilderImpl;
import fpml.confirmation.NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Impl;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.meta.NoTouchRateObservationSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NoTouchRateObservationSequence1", builder=NoTouchRateObservationSequence1.NoTouchRateObservationSequence1BuilderImpl.class, version="${project.version}")
public interface NoTouchRateObservationSequence1 extends RosettaModelObject {

	NoTouchRateObservationSequence1Meta metaData = new NoTouchRateObservationSequence1Meta();

	/*********************** Getter Methods  ***********************/
	ExerciseSideEnum getExerciseSide();
	SettlementTypeEnum getSettlementType();
	SimplePayment getCashSettlement();
	PhysicalSettlement getPhysicalSettlement();
	NonNegativePayment getPayment();
	ClearingInstructions getClearingInstructions();

	/*********************** Build Methods  ***********************/
	NoTouchRateObservationSequence1 build();
	
	NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder toBuilder();
	
	static NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder builder() {
		return new NoTouchRateObservationSequence1.NoTouchRateObservationSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchRateObservationSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchRateObservationSequence1> getType() {
		return NoTouchRateObservationSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.class, getCashSettlement());
		processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.class, getPhysicalSettlement());
		processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.class, getPayment());
		processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.class, getClearingInstructions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchRateObservationSequence1Builder extends NoTouchRateObservationSequence1, RosettaModelObjectBuilder {
		SimplePayment.SimplePaymentBuilder getOrCreateCashSettlement();
		SimplePayment.SimplePaymentBuilder getCashSettlement();
		PhysicalSettlement.PhysicalSettlementBuilder getOrCreatePhysicalSettlement();
		PhysicalSettlement.PhysicalSettlementBuilder getPhysicalSettlement();
		NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment();
		NonNegativePayment.NonNegativePaymentBuilder getPayment();
		ClearingInstructions.ClearingInstructionsBuilder getOrCreateClearingInstructions();
		ClearingInstructions.ClearingInstructionsBuilder getClearingInstructions();
		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setExerciseSide(ExerciseSideEnum exerciseSide);
		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setSettlementType(SettlementTypeEnum settlementType);
		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setCashSettlement(SimplePayment cashSettlement);
		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setPhysicalSettlement(PhysicalSettlement physicalSettlement);
		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setPayment(NonNegativePayment payment);
		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setClearingInstructions(ClearingInstructions clearingInstructions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.SimplePaymentBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.PhysicalSettlementBuilder.class, getPhysicalSettlement());
			processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.ClearingInstructionsBuilder.class, getClearingInstructions());
		}
		

		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder prune();
	}

	/*********************** Immutable Implementation of NoTouchRateObservationSequence1  ***********************/
	class NoTouchRateObservationSequence1Impl implements NoTouchRateObservationSequence1 {
		private final ExerciseSideEnum exerciseSide;
		private final SettlementTypeEnum settlementType;
		private final SimplePayment cashSettlement;
		private final PhysicalSettlement physicalSettlement;
		private final NonNegativePayment payment;
		private final ClearingInstructions clearingInstructions;
		
		protected NoTouchRateObservationSequence1Impl(NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder builder) {
			this.exerciseSide = builder.getExerciseSide();
			this.settlementType = builder.getSettlementType();
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exerciseSide")
		public ExerciseSideEnum getExerciseSide() {
			return exerciseSide;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public SimplePayment getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		public PhysicalSettlement getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		@RosettaAttribute("payment")
		public NonNegativePayment getPayment() {
			return payment;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public ClearingInstructions getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public NoTouchRateObservationSequence1 build() {
			return this;
		}
		
		@Override
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder toBuilder() {
			NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder builder) {
			ofNullable(getExerciseSide()).ifPresent(builder::setExerciseSide);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchRateObservationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(exerciseSide, _that.getExerciseSide())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseSide != null ? exerciseSide.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchRateObservationSequence1 {" +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchRateObservationSequence1  ***********************/
	class NoTouchRateObservationSequence1BuilderImpl implements NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder {
	
		protected ExerciseSideEnum exerciseSide;
		protected SettlementTypeEnum settlementType;
		protected SimplePayment.SimplePaymentBuilder cashSettlement;
		protected PhysicalSettlement.PhysicalSettlementBuilder physicalSettlement;
		protected NonNegativePayment.NonNegativePaymentBuilder payment;
		protected ClearingInstructions.ClearingInstructionsBuilder clearingInstructions;
	
		public NoTouchRateObservationSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exerciseSide")
		public ExerciseSideEnum getExerciseSide() {
			return exerciseSide;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public SimplePayment.SimplePaymentBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateCashSettlement() {
			SimplePayment.SimplePaymentBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = SimplePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		public PhysicalSettlement.PhysicalSettlementBuilder getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public PhysicalSettlement.PhysicalSettlementBuilder getOrCreatePhysicalSettlement() {
			PhysicalSettlement.PhysicalSettlementBuilder result;
			if (physicalSettlement!=null) {
				result = physicalSettlement;
			}
			else {
				result = physicalSettlement = PhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		public NonNegativePayment.NonNegativePaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment() {
			NonNegativePayment.NonNegativePaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = NonNegativePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public ClearingInstructions.ClearingInstructionsBuilder getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder getOrCreateClearingInstructions() {
			ClearingInstructions.ClearingInstructionsBuilder result;
			if (clearingInstructions!=null) {
				result = clearingInstructions;
			}
			else {
				result = clearingInstructions = ClearingInstructions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseSide")
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setExerciseSide(ExerciseSideEnum exerciseSide) {
			this.exerciseSide = exerciseSide==null?null:exerciseSide;
			return this;
		}
		@Override
		@RosettaAttribute("settlementType")
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlement")
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setCashSettlement(SimplePayment cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("physicalSettlement")
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setPhysicalSettlement(PhysicalSettlement physicalSettlement) {
			this.physicalSettlement = physicalSettlement==null?null:physicalSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setPayment(NonNegativePayment payment) {
			this.payment = payment==null?null:payment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearingInstructions")
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder setClearingInstructions(ClearingInstructions clearingInstructions) {
			this.clearingInstructions = clearingInstructions==null?null:clearingInstructions.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchRateObservationSequence1 build() {
			return new NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Impl(this);
		}
		
		@Override
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder prune() {
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseSide()!=null) return true;
			if (getSettlementType()!=null) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getPhysicalSettlement()!=null && getPhysicalSettlement().hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder o = (NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder) other;
			
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			
			merger.mergeBasic(getExerciseSide(), o.getExerciseSide(), this::setExerciseSide);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchRateObservationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(exerciseSide, _that.getExerciseSide())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseSide != null ? exerciseSide.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchRateObservationSequence1Builder {" +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions +
			'}';
		}
	}
}
