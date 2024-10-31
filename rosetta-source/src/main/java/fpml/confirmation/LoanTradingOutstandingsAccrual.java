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
import fpml.confirmation.AbstractTradingAccrual;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualBuilder;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualImpl;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.LoanTradingOutstandingsAccrual;
import fpml.confirmation.LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder;
import fpml.confirmation.LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilderImpl;
import fpml.confirmation.LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.LoanTradingOutstandingsAccrualMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that incorporates sub-periods of an accrual calculation for a traded outstanding contract.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingOutstandingsAccrual", builder=LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilderImpl.class, version="${project.version}")
public interface LoanTradingOutstandingsAccrual extends AbstractTradingAccrual {

	LoanTradingOutstandingsAccrualMeta metaData = new LoanTradingOutstandingsAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique id for the loan contract.
	 */
	LoanContractReference getLoanContractReference();

	/*********************** Build Methods  ***********************/
	LoanTradingOutstandingsAccrual build();
	
	LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder toBuilder();
	
	static LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder builder() {
		return new LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingOutstandingsAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingOutstandingsAccrual> getType() {
		return LoanTradingOutstandingsAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.class, getAccrualPeriod());
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingOutstandingsAccrualBuilder extends LoanTradingOutstandingsAccrual, AbstractTradingAccrual.AbstractTradingAccrualBuilder {
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference();
		LoanContractReference.LoanContractReferenceBuilder getLoanContractReference();
		LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder setAmount(NonNegativeMoney amount);
		LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod0);
		LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod1, int _idx);
		LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod2);
		LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod3);
		LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder setLoanContractReference(LoanContractReference loanContractReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualPeriod());
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
		}
		

		LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingOutstandingsAccrual  ***********************/
	class LoanTradingOutstandingsAccrualImpl extends AbstractTradingAccrual.AbstractTradingAccrualImpl implements LoanTradingOutstandingsAccrual {
		private final LoanContractReference loanContractReference;
		
		protected LoanTradingOutstandingsAccrualImpl(LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder builder) {
			super(builder);
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractReference getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanTradingOutstandingsAccrual build() {
			return this;
		}
		
		@Override
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder toBuilder() {
			LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingOutstandingsAccrual _that = getType().cast(o);
		
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingOutstandingsAccrual {" +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradingOutstandingsAccrual  ***********************/
	class LoanTradingOutstandingsAccrualBuilderImpl extends AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl  implements LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder {
	
		protected LoanContractReference.LoanContractReferenceBuilder loanContractReference;
	
		public LoanTradingOutstandingsAccrualBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractReference.LoanContractReferenceBuilder getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference() {
			LoanContractReference.LoanContractReferenceBuilder result;
			if (loanContractReference!=null) {
				result = loanContractReference;
			}
			else {
				result = loanContractReference = LoanContractReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrualPeriod")
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod) {
			if (accrualPeriod!=null) this.accrualPeriod.add(accrualPeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod, int _idx) {
			getIndex(this.accrualPeriod, _idx, () -> accrualPeriod.toBuilder());
			return this;
		}
		@Override 
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods != null) {
				for (AccrualPeriod toAdd : accrualPeriods) {
					this.accrualPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods == null)  {
				this.accrualPeriod = new ArrayList<>();
			}
			else {
				this.accrualPeriod = accrualPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingOutstandingsAccrual build() {
			return new LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualImpl(this);
		}
		
		@Override
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder prune() {
			super.prune();
			if (loanContractReference!=null && !loanContractReference.prune().hasData()) loanContractReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanContractReference()!=null && getLoanContractReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder o = (LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder) other;
			
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::setLoanContractReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingOutstandingsAccrual _that = getType().cast(o);
		
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingOutstandingsAccrualBuilder {" +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}
}
