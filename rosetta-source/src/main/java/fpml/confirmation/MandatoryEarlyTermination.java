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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.MandatoryEarlyTermination;
import fpml.confirmation.MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder;
import fpml.confirmation.MandatoryEarlyTermination.MandatoryEarlyTerminationBuilderImpl;
import fpml.confirmation.MandatoryEarlyTermination.MandatoryEarlyTerminationImpl;
import fpml.confirmation.MandatoryEarlyTerminationAdjustedDates;
import fpml.confirmation.meta.MandatoryEarlyTerminationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to define an early termination provision for which exercise is mandatory.
 * @version ${project.version}
 */
@RosettaDataType(value="MandatoryEarlyTermination", builder=MandatoryEarlyTermination.MandatoryEarlyTerminationBuilderImpl.class, version="${project.version}")
public interface MandatoryEarlyTermination extends RosettaModelObject {

	MandatoryEarlyTerminationMeta metaData = new MandatoryEarlyTerminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The early termination date associated with a mandatory early termination of a swap.
	 */
	AdjustableDate getMandatoryEarlyTerminationDate();
	/**
	 * The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
	 */
	CalculationAgent getCalculationAgent();
	/**
	 * If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement prodcedure. If not specified, then physical settlement is applicable.
	 */
	CashSettlement getCashSettlement();
	/**
	 * The adjusted dates associated with a mandatory early termination provision. These dates have been adjusted for any applicable business day convention.
	 */
	MandatoryEarlyTerminationAdjustedDates getMandatoryEarlyTerminationAdjustedDates();
	String getId();

	/*********************** Build Methods  ***********************/
	MandatoryEarlyTermination build();
	
	MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder toBuilder();
	
	static MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder builder() {
		return new MandatoryEarlyTermination.MandatoryEarlyTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryEarlyTermination> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MandatoryEarlyTermination> getType() {
		return MandatoryEarlyTermination.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mandatoryEarlyTerminationDate"), processor, AdjustableDate.class, getMandatoryEarlyTerminationDate());
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.class, getCashSettlement());
		processRosetta(path.newSubPath("mandatoryEarlyTerminationAdjustedDates"), processor, MandatoryEarlyTerminationAdjustedDates.class, getMandatoryEarlyTerminationAdjustedDates());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MandatoryEarlyTerminationBuilder extends MandatoryEarlyTermination, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateMandatoryEarlyTerminationDate();
		AdjustableDate.AdjustableDateBuilder getMandatoryEarlyTerminationDate();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		CashSettlement.CashSettlementBuilder getOrCreateCashSettlement();
		CashSettlement.CashSettlementBuilder getCashSettlement();
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder getOrCreateMandatoryEarlyTerminationAdjustedDates();
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder getMandatoryEarlyTerminationAdjustedDates();
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setMandatoryEarlyTerminationDate(AdjustableDate mandatoryEarlyTerminationDate);
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setCalculationAgent(CalculationAgent calculationAgent);
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setCashSettlement(CashSettlement cashSettlement);
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setMandatoryEarlyTerminationAdjustedDates(MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates);
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mandatoryEarlyTerminationDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getMandatoryEarlyTerminationDate());
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.CashSettlementBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("mandatoryEarlyTerminationAdjustedDates"), processor, MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder.class, getMandatoryEarlyTerminationAdjustedDates());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryEarlyTermination  ***********************/
	class MandatoryEarlyTerminationImpl implements MandatoryEarlyTermination {
		private final AdjustableDate mandatoryEarlyTerminationDate;
		private final CalculationAgent calculationAgent;
		private final CashSettlement cashSettlement;
		private final MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates;
		private final String id;
		
		protected MandatoryEarlyTerminationImpl(MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder builder) {
			this.mandatoryEarlyTerminationDate = ofNullable(builder.getMandatoryEarlyTerminationDate()).map(f->f.build()).orElse(null);
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.mandatoryEarlyTerminationAdjustedDates = ofNullable(builder.getMandatoryEarlyTerminationAdjustedDates()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDate")
		public AdjustableDate getMandatoryEarlyTerminationDate() {
			return mandatoryEarlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public CashSettlement getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationAdjustedDates")
		public MandatoryEarlyTerminationAdjustedDates getMandatoryEarlyTerminationAdjustedDates() {
			return mandatoryEarlyTerminationAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public MandatoryEarlyTermination build() {
			return this;
		}
		
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder toBuilder() {
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder builder) {
			ofNullable(getMandatoryEarlyTerminationDate()).ifPresent(builder::setMandatoryEarlyTerminationDate);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getMandatoryEarlyTerminationAdjustedDates()).ifPresent(builder::setMandatoryEarlyTerminationAdjustedDates);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryEarlyTerminationDate, _that.getMandatoryEarlyTerminationDate())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationAdjustedDates, _that.getMandatoryEarlyTerminationAdjustedDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryEarlyTerminationDate != null ? mandatoryEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationAdjustedDates != null ? mandatoryEarlyTerminationAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTermination {" +
				"mandatoryEarlyTerminationDate=" + this.mandatoryEarlyTerminationDate + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"mandatoryEarlyTerminationAdjustedDates=" + this.mandatoryEarlyTerminationAdjustedDates + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of MandatoryEarlyTermination  ***********************/
	class MandatoryEarlyTerminationBuilderImpl implements MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder {
	
		protected AdjustableDate.AdjustableDateBuilder mandatoryEarlyTerminationDate;
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected CashSettlement.CashSettlementBuilder cashSettlement;
		protected MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder mandatoryEarlyTerminationAdjustedDates;
		protected String id;
	
		public MandatoryEarlyTerminationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDate")
		public AdjustableDate.AdjustableDateBuilder getMandatoryEarlyTerminationDate() {
			return mandatoryEarlyTerminationDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateMandatoryEarlyTerminationDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (mandatoryEarlyTerminationDate!=null) {
				result = mandatoryEarlyTerminationDate;
			}
			else {
				result = mandatoryEarlyTerminationDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public CashSettlement.CashSettlementBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder getOrCreateCashSettlement() {
			CashSettlement.CashSettlementBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = CashSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationAdjustedDates")
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder getMandatoryEarlyTerminationAdjustedDates() {
			return mandatoryEarlyTerminationAdjustedDates;
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder getOrCreateMandatoryEarlyTerminationAdjustedDates() {
			MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder result;
			if (mandatoryEarlyTerminationAdjustedDates!=null) {
				result = mandatoryEarlyTerminationAdjustedDates;
			}
			else {
				result = mandatoryEarlyTerminationAdjustedDates = MandatoryEarlyTerminationAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDate")
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setMandatoryEarlyTerminationDate(AdjustableDate mandatoryEarlyTerminationDate) {
			this.mandatoryEarlyTerminationDate = mandatoryEarlyTerminationDate==null?null:mandatoryEarlyTerminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationAgent")
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setCalculationAgent(CalculationAgent calculationAgent) {
			this.calculationAgent = calculationAgent==null?null:calculationAgent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlement")
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setCashSettlement(CashSettlement cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationAdjustedDates")
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setMandatoryEarlyTerminationAdjustedDates(MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates) {
			this.mandatoryEarlyTerminationAdjustedDates = mandatoryEarlyTerminationAdjustedDates==null?null:mandatoryEarlyTerminationAdjustedDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public MandatoryEarlyTermination build() {
			return new MandatoryEarlyTermination.MandatoryEarlyTerminationImpl(this);
		}
		
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder prune() {
			if (mandatoryEarlyTerminationDate!=null && !mandatoryEarlyTerminationDate.prune().hasData()) mandatoryEarlyTerminationDate = null;
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (mandatoryEarlyTerminationAdjustedDates!=null && !mandatoryEarlyTerminationAdjustedDates.prune().hasData()) mandatoryEarlyTerminationAdjustedDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMandatoryEarlyTerminationDate()!=null && getMandatoryEarlyTerminationDate().hasData()) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getMandatoryEarlyTerminationAdjustedDates()!=null && getMandatoryEarlyTerminationAdjustedDates().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder o = (MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getMandatoryEarlyTerminationDate(), o.getMandatoryEarlyTerminationDate(), this::setMandatoryEarlyTerminationDate);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getMandatoryEarlyTerminationAdjustedDates(), o.getMandatoryEarlyTerminationAdjustedDates(), this::setMandatoryEarlyTerminationAdjustedDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryEarlyTerminationDate, _that.getMandatoryEarlyTerminationDate())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationAdjustedDates, _that.getMandatoryEarlyTerminationAdjustedDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryEarlyTerminationDate != null ? mandatoryEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationAdjustedDates != null ? mandatoryEarlyTerminationAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationBuilder {" +
				"mandatoryEarlyTerminationDate=" + this.mandatoryEarlyTerminationDate + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"mandatoryEarlyTerminationAdjustedDates=" + this.mandatoryEarlyTerminationAdjustedDates + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
