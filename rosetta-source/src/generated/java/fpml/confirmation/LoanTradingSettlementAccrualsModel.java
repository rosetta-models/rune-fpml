package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.LoanTradingAccruingFeeAccrual;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual;
import fpml.confirmation.LoanTradingNonRecurringFee;
import fpml.confirmation.LoanTradingOutstandingsAccrual;
import fpml.confirmation.LoanTradingSettlementAccrualsModel;
import fpml.confirmation.LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder;
import fpml.confirmation.LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilderImpl;
import fpml.confirmation.LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelImpl;
import fpml.confirmation.meta.LoanTradingSettlementAccrualsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model which contains all relevant amounts to settle a loan trade with accrued interest and fees.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingSettlementAccrualsModel", builder=LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilderImpl.class, version="${project.version}")
public interface LoanTradingSettlementAccrualsModel extends RosettaModelObject {

	LoanTradingSettlementAccrualsModelMeta metaData = new LoanTradingSettlementAccrualsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Details of the amount of on-going fees accrued by the traded portion of a loan contract.
	 */
	List<? extends LoanTradingAccruingFeeAccrual> getAccruingFee();
	/**
	 * Details of the amount of on-going fees accrued by the traded portion of a loan contract.
	 */
	List<? extends LoanTradingNonRecurringFee> getNonRecurringFee();
	/**
	 * Details of the amount of interest accrued by the traded portion of a loan contract.
	 */
	List<? extends LoanTradingOutstandingsAccrual> getInterest();
	/**
	 * Details of the amount of interest accrued by the traded portion of a loan contract.
	 */
	List<? extends LoanTradingLetterOfCreditAccrual> getLetterOfCreditFee();

	/*********************** Build Methods  ***********************/
	LoanTradingSettlementAccrualsModel build();
	
	LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder toBuilder();
	
	static LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder builder() {
		return new LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingSettlementAccrualsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingSettlementAccrualsModel> getType() {
		return LoanTradingSettlementAccrualsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accruingFee"), processor, LoanTradingAccruingFeeAccrual.class, getAccruingFee());
		processRosetta(path.newSubPath("nonRecurringFee"), processor, LoanTradingNonRecurringFee.class, getNonRecurringFee());
		processRosetta(path.newSubPath("interest"), processor, LoanTradingOutstandingsAccrual.class, getInterest());
		processRosetta(path.newSubPath("letterOfCreditFee"), processor, LoanTradingLetterOfCreditAccrual.class, getLetterOfCreditFee());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingSettlementAccrualsModelBuilder extends LoanTradingSettlementAccrualsModel, RosettaModelObjectBuilder {
		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder getOrCreateAccruingFee(int _index);
		List<? extends LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder> getAccruingFee();
		LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder getOrCreateNonRecurringFee(int _index);
		List<? extends LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder> getNonRecurringFee();
		LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder getOrCreateInterest(int _index);
		List<? extends LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder> getInterest();
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder getOrCreateLetterOfCreditFee(int _index);
		List<? extends LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder> getLetterOfCreditFee();
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addAccruingFee(LoanTradingAccruingFeeAccrual accruingFee0);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addAccruingFee(LoanTradingAccruingFeeAccrual accruingFee1, int _idx);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addAccruingFee(List<? extends LoanTradingAccruingFeeAccrual> accruingFee2);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder setAccruingFee(List<? extends LoanTradingAccruingFeeAccrual> accruingFee3);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addNonRecurringFee(LoanTradingNonRecurringFee nonRecurringFee0);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addNonRecurringFee(LoanTradingNonRecurringFee nonRecurringFee1, int _idx);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addNonRecurringFee(List<? extends LoanTradingNonRecurringFee> nonRecurringFee2);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder setNonRecurringFee(List<? extends LoanTradingNonRecurringFee> nonRecurringFee3);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addInterest(LoanTradingOutstandingsAccrual interest0);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addInterest(LoanTradingOutstandingsAccrual interest1, int _idx);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addInterest(List<? extends LoanTradingOutstandingsAccrual> interest2);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder setInterest(List<? extends LoanTradingOutstandingsAccrual> interest3);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addLetterOfCreditFee(LoanTradingLetterOfCreditAccrual letterOfCreditFee0);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addLetterOfCreditFee(LoanTradingLetterOfCreditAccrual letterOfCreditFee1, int _idx);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addLetterOfCreditFee(List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditFee2);
		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder setLetterOfCreditFee(List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditFee3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accruingFee"), processor, LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder.class, getAccruingFee());
			processRosetta(path.newSubPath("nonRecurringFee"), processor, LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder.class, getNonRecurringFee());
			processRosetta(path.newSubPath("interest"), processor, LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder.class, getInterest());
			processRosetta(path.newSubPath("letterOfCreditFee"), processor, LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder.class, getLetterOfCreditFee());
		}
		

		LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingSettlementAccrualsModel  ***********************/
	class LoanTradingSettlementAccrualsModelImpl implements LoanTradingSettlementAccrualsModel {
		private final List<? extends LoanTradingAccruingFeeAccrual> accruingFee;
		private final List<? extends LoanTradingNonRecurringFee> nonRecurringFee;
		private final List<? extends LoanTradingOutstandingsAccrual> interest;
		private final List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditFee;
		
		protected LoanTradingSettlementAccrualsModelImpl(LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder builder) {
			this.accruingFee = ofNullable(builder.getAccruingFee()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.nonRecurringFee = ofNullable(builder.getNonRecurringFee()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interest = ofNullable(builder.getInterest()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.letterOfCreditFee = ofNullable(builder.getLetterOfCreditFee()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accruingFee")
		public List<? extends LoanTradingAccruingFeeAccrual> getAccruingFee() {
			return accruingFee;
		}
		
		@Override
		@RosettaAttribute("nonRecurringFee")
		public List<? extends LoanTradingNonRecurringFee> getNonRecurringFee() {
			return nonRecurringFee;
		}
		
		@Override
		@RosettaAttribute("interest")
		public List<? extends LoanTradingOutstandingsAccrual> getInterest() {
			return interest;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditFee")
		public List<? extends LoanTradingLetterOfCreditAccrual> getLetterOfCreditFee() {
			return letterOfCreditFee;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel build() {
			return this;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder toBuilder() {
			LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder builder) {
			ofNullable(getAccruingFee()).ifPresent(builder::setAccruingFee);
			ofNullable(getNonRecurringFee()).ifPresent(builder::setNonRecurringFee);
			ofNullable(getInterest()).ifPresent(builder::setInterest);
			ofNullable(getLetterOfCreditFee()).ifPresent(builder::setLetterOfCreditFee);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingSettlementAccrualsModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accruingFee, _that.getAccruingFee())) return false;
			if (!ListEquals.listEquals(nonRecurringFee, _that.getNonRecurringFee())) return false;
			if (!ListEquals.listEquals(interest, _that.getInterest())) return false;
			if (!ListEquals.listEquals(letterOfCreditFee, _that.getLetterOfCreditFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accruingFee != null ? accruingFee.hashCode() : 0);
			_result = 31 * _result + (nonRecurringFee != null ? nonRecurringFee.hashCode() : 0);
			_result = 31 * _result + (interest != null ? interest.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditFee != null ? letterOfCreditFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingSettlementAccrualsModel {" +
				"accruingFee=" + this.accruingFee + ", " +
				"nonRecurringFee=" + this.nonRecurringFee + ", " +
				"interest=" + this.interest + ", " +
				"letterOfCreditFee=" + this.letterOfCreditFee +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingSettlementAccrualsModel  ***********************/
	class LoanTradingSettlementAccrualsModelBuilderImpl implements LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder {
	
		protected List<LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder> accruingFee = new ArrayList<>();
		protected List<LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder> nonRecurringFee = new ArrayList<>();
		protected List<LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder> interest = new ArrayList<>();
		protected List<LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder> letterOfCreditFee = new ArrayList<>();
	
		public LoanTradingSettlementAccrualsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accruingFee")
		public List<? extends LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder> getAccruingFee() {
			return accruingFee;
		}
		
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder getOrCreateAccruingFee(int _index) {
		
			if (accruingFee==null) {
				this.accruingFee = new ArrayList<>();
			}
			LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder result;
			return getIndex(accruingFee, _index, () -> {
						LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder newAccruingFee = LoanTradingAccruingFeeAccrual.builder();
						return newAccruingFee;
					});
		}
		
		@Override
		@RosettaAttribute("nonRecurringFee")
		public List<? extends LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder> getNonRecurringFee() {
			return nonRecurringFee;
		}
		
		public LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder getOrCreateNonRecurringFee(int _index) {
		
			if (nonRecurringFee==null) {
				this.nonRecurringFee = new ArrayList<>();
			}
			LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder result;
			return getIndex(nonRecurringFee, _index, () -> {
						LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder newNonRecurringFee = LoanTradingNonRecurringFee.builder();
						return newNonRecurringFee;
					});
		}
		
		@Override
		@RosettaAttribute("interest")
		public List<? extends LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder> getInterest() {
			return interest;
		}
		
		public LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder getOrCreateInterest(int _index) {
		
			if (interest==null) {
				this.interest = new ArrayList<>();
			}
			LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder result;
			return getIndex(interest, _index, () -> {
						LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder newInterest = LoanTradingOutstandingsAccrual.builder();
						return newInterest;
					});
		}
		
		@Override
		@RosettaAttribute("letterOfCreditFee")
		public List<? extends LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder> getLetterOfCreditFee() {
			return letterOfCreditFee;
		}
		
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder getOrCreateLetterOfCreditFee(int _index) {
		
			if (letterOfCreditFee==null) {
				this.letterOfCreditFee = new ArrayList<>();
			}
			LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder result;
			return getIndex(letterOfCreditFee, _index, () -> {
						LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder newLetterOfCreditFee = LoanTradingLetterOfCreditAccrual.builder();
						return newLetterOfCreditFee;
					});
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addAccruingFee(LoanTradingAccruingFeeAccrual accruingFee) {
			if (accruingFee!=null) this.accruingFee.add(accruingFee.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addAccruingFee(LoanTradingAccruingFeeAccrual accruingFee, int _idx) {
			getIndex(this.accruingFee, _idx, () -> accruingFee.toBuilder());
			return this;
		}
		@Override 
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addAccruingFee(List<? extends LoanTradingAccruingFeeAccrual> accruingFees) {
			if (accruingFees != null) {
				for (LoanTradingAccruingFeeAccrual toAdd : accruingFees) {
					this.accruingFee.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accruingFee")
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder setAccruingFee(List<? extends LoanTradingAccruingFeeAccrual> accruingFees) {
			if (accruingFees == null)  {
				this.accruingFee = new ArrayList<>();
			}
			else {
				this.accruingFee = accruingFees.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addNonRecurringFee(LoanTradingNonRecurringFee nonRecurringFee) {
			if (nonRecurringFee!=null) this.nonRecurringFee.add(nonRecurringFee.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addNonRecurringFee(LoanTradingNonRecurringFee nonRecurringFee, int _idx) {
			getIndex(this.nonRecurringFee, _idx, () -> nonRecurringFee.toBuilder());
			return this;
		}
		@Override 
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addNonRecurringFee(List<? extends LoanTradingNonRecurringFee> nonRecurringFees) {
			if (nonRecurringFees != null) {
				for (LoanTradingNonRecurringFee toAdd : nonRecurringFees) {
					this.nonRecurringFee.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("nonRecurringFee")
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder setNonRecurringFee(List<? extends LoanTradingNonRecurringFee> nonRecurringFees) {
			if (nonRecurringFees == null)  {
				this.nonRecurringFee = new ArrayList<>();
			}
			else {
				this.nonRecurringFee = nonRecurringFees.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addInterest(LoanTradingOutstandingsAccrual interest) {
			if (interest!=null) this.interest.add(interest.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addInterest(LoanTradingOutstandingsAccrual interest, int _idx) {
			getIndex(this.interest, _idx, () -> interest.toBuilder());
			return this;
		}
		@Override 
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addInterest(List<? extends LoanTradingOutstandingsAccrual> interests) {
			if (interests != null) {
				for (LoanTradingOutstandingsAccrual toAdd : interests) {
					this.interest.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("interest")
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder setInterest(List<? extends LoanTradingOutstandingsAccrual> interests) {
			if (interests == null)  {
				this.interest = new ArrayList<>();
			}
			else {
				this.interest = interests.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addLetterOfCreditFee(LoanTradingLetterOfCreditAccrual letterOfCreditFee) {
			if (letterOfCreditFee!=null) this.letterOfCreditFee.add(letterOfCreditFee.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addLetterOfCreditFee(LoanTradingLetterOfCreditAccrual letterOfCreditFee, int _idx) {
			getIndex(this.letterOfCreditFee, _idx, () -> letterOfCreditFee.toBuilder());
			return this;
		}
		@Override 
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder addLetterOfCreditFee(List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditFees) {
			if (letterOfCreditFees != null) {
				for (LoanTradingLetterOfCreditAccrual toAdd : letterOfCreditFees) {
					this.letterOfCreditFee.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("letterOfCreditFee")
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder setLetterOfCreditFee(List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditFees) {
			if (letterOfCreditFees == null)  {
				this.letterOfCreditFee = new ArrayList<>();
			}
			else {
				this.letterOfCreditFee = letterOfCreditFees.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanTradingSettlementAccrualsModel build() {
			return new LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelImpl(this);
		}
		
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder prune() {
			accruingFee = accruingFee.stream().filter(b->b!=null).<LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			nonRecurringFee = nonRecurringFee.stream().filter(b->b!=null).<LoanTradingNonRecurringFee.LoanTradingNonRecurringFeeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			interest = interest.stream().filter(b->b!=null).<LoanTradingOutstandingsAccrual.LoanTradingOutstandingsAccrualBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			letterOfCreditFee = letterOfCreditFee.stream().filter(b->b!=null).<LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccruingFee()!=null && getAccruingFee().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNonRecurringFee()!=null && getNonRecurringFee().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInterest()!=null && getInterest().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLetterOfCreditFee()!=null && getLetterOfCreditFee().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder o = (LoanTradingSettlementAccrualsModel.LoanTradingSettlementAccrualsModelBuilder) other;
			
			merger.mergeRosetta(getAccruingFee(), o.getAccruingFee(), this::getOrCreateAccruingFee);
			merger.mergeRosetta(getNonRecurringFee(), o.getNonRecurringFee(), this::getOrCreateNonRecurringFee);
			merger.mergeRosetta(getInterest(), o.getInterest(), this::getOrCreateInterest);
			merger.mergeRosetta(getLetterOfCreditFee(), o.getLetterOfCreditFee(), this::getOrCreateLetterOfCreditFee);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingSettlementAccrualsModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accruingFee, _that.getAccruingFee())) return false;
			if (!ListEquals.listEquals(nonRecurringFee, _that.getNonRecurringFee())) return false;
			if (!ListEquals.listEquals(interest, _that.getInterest())) return false;
			if (!ListEquals.listEquals(letterOfCreditFee, _that.getLetterOfCreditFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accruingFee != null ? accruingFee.hashCode() : 0);
			_result = 31 * _result + (nonRecurringFee != null ? nonRecurringFee.hashCode() : 0);
			_result = 31 * _result + (interest != null ? interest.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditFee != null ? letterOfCreditFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingSettlementAccrualsModelBuilder {" +
				"accruingFee=" + this.accruingFee + ", " +
				"nonRecurringFee=" + this.nonRecurringFee + ", " +
				"interest=" + this.interest + ", " +
				"letterOfCreditFee=" + this.letterOfCreditFee +
			'}';
		}
	}
}
