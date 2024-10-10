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
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilderImpl;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.LoanTradingLetterOfCreditAccrualMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that incorporates sub-periods of an accrual calculation for a traded letter of credit.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingLetterOfCreditAccrual", builder=LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilderImpl.class, version="${project.version}")
public interface LoanTradingLetterOfCreditAccrual extends AbstractTradingAccrual {

	LoanTradingLetterOfCreditAccrualMeta metaData = new LoanTradingLetterOfCreditAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique identifier for the letter of credit.
	 */
	LetterOfCreditReference getLetterOfCreditReference();

	/*********************** Build Methods  ***********************/
	LoanTradingLetterOfCreditAccrual build();
	
	LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder toBuilder();
	
	static LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder builder() {
		return new LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingLetterOfCreditAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingLetterOfCreditAccrual> getType() {
		return LoanTradingLetterOfCreditAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.class, getAccrualPeriod());
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingLetterOfCreditAccrualBuilder extends LoanTradingLetterOfCreditAccrual, AbstractTradingAccrual.AbstractTradingAccrualBuilder {
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference();
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference();
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setAmount(NonNegativeMoney amount);
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod0);
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod1, int _idx);
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod2);
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod3);
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualPeriod());
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
		}
		

		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingLetterOfCreditAccrual  ***********************/
	class LoanTradingLetterOfCreditAccrualImpl extends AbstractTradingAccrual.AbstractTradingAccrualImpl implements LoanTradingLetterOfCreditAccrual {
		private final LetterOfCreditReference letterOfCreditReference;
		
		protected LoanTradingLetterOfCreditAccrualImpl(LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder builder) {
			super(builder);
			this.letterOfCreditReference = ofNullable(builder.getLetterOfCreditReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LetterOfCreditReference getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual build() {
			return this;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder toBuilder() {
			LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLetterOfCreditReference()).ifPresent(builder::setLetterOfCreditReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingLetterOfCreditAccrual _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingLetterOfCreditAccrual {" +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradingLetterOfCreditAccrual  ***********************/
	class LoanTradingLetterOfCreditAccrualBuilderImpl extends AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl  implements LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder {
	
		protected LetterOfCreditReference.LetterOfCreditReferenceBuilder letterOfCreditReference;
	
		public LoanTradingLetterOfCreditAccrualBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference() {
			LetterOfCreditReference.LetterOfCreditReferenceBuilder result;
			if (letterOfCreditReference!=null) {
				result = letterOfCreditReference;
			}
			else {
				result = letterOfCreditReference = LetterOfCreditReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod) {
			if (accrualPeriod!=null) this.accrualPeriod.add(accrualPeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod, int _idx) {
			getIndex(this.accrualPeriod, _idx, () -> accrualPeriod.toBuilder());
			return this;
		}
		@Override 
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods != null) {
				for (AccrualPeriod toAdd : accrualPeriods) {
					this.accrualPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accrualPeriod")
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
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
		@RosettaAttribute("letterOfCreditReference")
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference) {
			this.letterOfCreditReference = letterOfCreditReference==null?null:letterOfCreditReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual build() {
			return new LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualImpl(this);
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder prune() {
			super.prune();
			if (letterOfCreditReference!=null && !letterOfCreditReference.prune().hasData()) letterOfCreditReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLetterOfCreditReference()!=null && getLetterOfCreditReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder o = (LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder) other;
			
			merger.mergeRosetta(getLetterOfCreditReference(), o.getLetterOfCreditReference(), this::setLetterOfCreditReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingLetterOfCreditAccrual _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingLetterOfCreditAccrualBuilder {" +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}' + " " + super.toString();
		}
	}
}
