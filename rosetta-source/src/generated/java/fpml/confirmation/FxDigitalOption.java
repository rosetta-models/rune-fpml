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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxDigitalOption;
import fpml.confirmation.FxDigitalOption.FxDigitalOptionBuilder;
import fpml.confirmation.FxDigitalOption.FxDigitalOptionBuilderImpl;
import fpml.confirmation.FxDigitalOption.FxDigitalOptionImpl;
import fpml.confirmation.FxDigitalOptionSequence0;
import fpml.confirmation.FxDigitalOptionSequence1;
import fpml.confirmation.FxOptionPayout;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.Option;
import fpml.confirmation.Option.OptionBuilder;
import fpml.confirmation.Option.OptionBuilderImpl;
import fpml.confirmation.Option.OptionImpl;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.FxDigitalOptionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An FX digital option transaction definition. Describes an option having a triggerable fixed payout.
 * @version ${project.version}
 */
@RosettaDataType(value="FxDigitalOption", builder=FxDigitalOption.FxDigitalOptionBuilderImpl.class, version="${project.version}")
public interface FxDigitalOption extends Option {

	FxDigitalOptionMeta metaData = new FxDigitalOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Effective date for a forward starting derivative. If this element is not present, the effective date is the trade date.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 */
	Period getTenorPeriod();
	FxDigitalOptionSequence0 getFxDigitalOptionSequence0();
	FxDigitalOptionSequence1 getFxDigitalOptionSequence1();
	/**
	 * A set of parameters defining procedures associated with the exercise.
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 * The amount of currency which becomes payable if and when a trigger event occurs.
	 */
	FxOptionPayout getPayout();
	/**
	 * Premium amount or premium installment amount for an option.
	 */
	List<? extends FxOptionPremium> getPremium();

	/*********************** Build Methods  ***********************/
	FxDigitalOption build();
	
	FxDigitalOption.FxDigitalOptionBuilder toBuilder();
	
	static FxDigitalOption.FxDigitalOptionBuilder builder() {
		return new FxDigitalOption.FxDigitalOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDigitalOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDigitalOption> getType() {
		return FxDigitalOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("tenorPeriod"), processor, Period.class, getTenorPeriod());
		processRosetta(path.newSubPath("fxDigitalOptionSequence0"), processor, FxDigitalOptionSequence0.class, getFxDigitalOptionSequence0());
		processRosetta(path.newSubPath("fxDigitalOptionSequence1"), processor, FxDigitalOptionSequence1.class, getFxDigitalOptionSequence1());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("payout"), processor, FxOptionPayout.class, getPayout());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDigitalOptionBuilder extends FxDigitalOption, Option.OptionBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		Period.PeriodBuilder getOrCreateTenorPeriod();
		Period.PeriodBuilder getTenorPeriod();
		FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder getOrCreateFxDigitalOptionSequence0();
		FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder getFxDigitalOptionSequence0();
		FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder getOrCreateFxDigitalOptionSequence1();
		FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder getFxDigitalOptionSequence1();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		FxOptionPayout.FxOptionPayoutBuilder getOrCreatePayout();
		FxOptionPayout.FxOptionPayoutBuilder getPayout();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int _index);
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		FxDigitalOption.FxDigitalOptionBuilder setProductModel(ProductModel productModel);
		FxDigitalOption.FxDigitalOptionBuilder setId(String id);
		FxDigitalOption.FxDigitalOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		FxDigitalOption.FxDigitalOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		FxDigitalOption.FxDigitalOptionBuilder setTenorPeriod(Period tenorPeriod);
		FxDigitalOption.FxDigitalOptionBuilder setFxDigitalOptionSequence0(FxDigitalOptionSequence0 fxDigitalOptionSequence0);
		FxDigitalOption.FxDigitalOptionBuilder setFxDigitalOptionSequence1(FxDigitalOptionSequence1 fxDigitalOptionSequence1);
		FxDigitalOption.FxDigitalOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxDigitalOption.FxDigitalOptionBuilder setPayout(FxOptionPayout payout);
		FxDigitalOption.FxDigitalOptionBuilder addPremium(FxOptionPremium premium0);
		FxDigitalOption.FxDigitalOptionBuilder addPremium(FxOptionPremium premium1, int _idx);
		FxDigitalOption.FxDigitalOptionBuilder addPremium(List<? extends FxOptionPremium> premium2);
		FxDigitalOption.FxDigitalOptionBuilder setPremium(List<? extends FxOptionPremium> premium3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("tenorPeriod"), processor, Period.PeriodBuilder.class, getTenorPeriod());
			processRosetta(path.newSubPath("fxDigitalOptionSequence0"), processor, FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder.class, getFxDigitalOptionSequence0());
			processRosetta(path.newSubPath("fxDigitalOptionSequence1"), processor, FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder.class, getFxDigitalOptionSequence1());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("payout"), processor, FxOptionPayout.FxOptionPayoutBuilder.class, getPayout());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
		}
		

		FxDigitalOption.FxDigitalOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxDigitalOption  ***********************/
	class FxDigitalOptionImpl extends Option.OptionImpl implements FxDigitalOption {
		private final AdjustableOrRelativeDate effectiveDate;
		private final Period tenorPeriod;
		private final FxDigitalOptionSequence0 fxDigitalOptionSequence0;
		private final FxDigitalOptionSequence1 fxDigitalOptionSequence1;
		private final ExerciseProcedure exerciseProcedure;
		private final FxOptionPayout payout;
		private final List<? extends FxOptionPremium> premium;
		
		protected FxDigitalOptionImpl(FxDigitalOption.FxDigitalOptionBuilder builder) {
			super(builder);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
			this.fxDigitalOptionSequence0 = ofNullable(builder.getFxDigitalOptionSequence0()).map(f->f.build()).orElse(null);
			this.fxDigitalOptionSequence1 = ofNullable(builder.getFxDigitalOptionSequence1()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.payout = ofNullable(builder.getPayout()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		public Period getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		@RosettaAttribute("fxDigitalOptionSequence0")
		public FxDigitalOptionSequence0 getFxDigitalOptionSequence0() {
			return fxDigitalOptionSequence0;
		}
		
		@Override
		@RosettaAttribute("fxDigitalOptionSequence1")
		public FxDigitalOptionSequence1 getFxDigitalOptionSequence1() {
			return fxDigitalOptionSequence1;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("payout")
		public FxOptionPayout getPayout() {
			return payout;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends FxOptionPremium> getPremium() {
			return premium;
		}
		
		@Override
		public FxDigitalOption build() {
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder toBuilder() {
			FxDigitalOption.FxDigitalOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDigitalOption.FxDigitalOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
			ofNullable(getFxDigitalOptionSequence0()).ifPresent(builder::setFxDigitalOptionSequence0);
			ofNullable(getFxDigitalOptionSequence1()).ifPresent(builder::setFxDigitalOptionSequence1);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getPayout()).ifPresent(builder::setPayout);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(fxDigitalOptionSequence0, _that.getFxDigitalOptionSequence0())) return false;
			if (!Objects.equals(fxDigitalOptionSequence1, _that.getFxDigitalOptionSequence1())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (fxDigitalOptionSequence0 != null ? fxDigitalOptionSequence0.hashCode() : 0);
			_result = 31 * _result + (fxDigitalOptionSequence1 != null ? fxDigitalOptionSequence1.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalOption {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"fxDigitalOptionSequence0=" + this.fxDigitalOptionSequence0 + ", " +
				"fxDigitalOptionSequence1=" + this.fxDigitalOptionSequence1 + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"payout=" + this.payout + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxDigitalOption  ***********************/
	class FxDigitalOptionBuilderImpl extends Option.OptionBuilderImpl  implements FxDigitalOption.FxDigitalOptionBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected Period.PeriodBuilder tenorPeriod;
		protected FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder fxDigitalOptionSequence0;
		protected FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder fxDigitalOptionSequence1;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected FxOptionPayout.FxOptionPayoutBuilder payout;
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
	
		public FxDigitalOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		public Period.PeriodBuilder getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenorPeriod() {
			Period.PeriodBuilder result;
			if (tenorPeriod!=null) {
				result = tenorPeriod;
			}
			else {
				result = tenorPeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxDigitalOptionSequence0")
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder getFxDigitalOptionSequence0() {
			return fxDigitalOptionSequence0;
		}
		
		@Override
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder getOrCreateFxDigitalOptionSequence0() {
			FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder result;
			if (fxDigitalOptionSequence0!=null) {
				result = fxDigitalOptionSequence0;
			}
			else {
				result = fxDigitalOptionSequence0 = FxDigitalOptionSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxDigitalOptionSequence1")
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder getFxDigitalOptionSequence1() {
			return fxDigitalOptionSequence1;
		}
		
		@Override
		public FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder getOrCreateFxDigitalOptionSequence1() {
			FxDigitalOptionSequence1.FxDigitalOptionSequence1Builder result;
			if (fxDigitalOptionSequence1!=null) {
				result = fxDigitalOptionSequence1;
			}
			else {
				result = fxDigitalOptionSequence1 = FxDigitalOptionSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedure.ExerciseProcedureBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payout")
		public FxOptionPayout.FxOptionPayoutBuilder getPayout() {
			return payout;
		}
		
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder getOrCreatePayout() {
			FxOptionPayout.FxOptionPayoutBuilder result;
			if (payout!=null) {
				result = payout;
			}
			else {
				result = payout = FxOptionPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium() {
			return premium;
		}
		
		public FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int _index) {
		
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			FxOptionPremium.FxOptionPremiumBuilder result;
			return getIndex(premium, _index, () -> {
						FxOptionPremium.FxOptionPremiumBuilder newPremium = FxOptionPremium.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxDigitalOption.FxDigitalOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxDigitalOption.FxDigitalOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public FxDigitalOption.FxDigitalOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FxDigitalOption.FxDigitalOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tenorPeriod")
		public FxDigitalOption.FxDigitalOptionBuilder setTenorPeriod(Period tenorPeriod) {
			this.tenorPeriod = tenorPeriod==null?null:tenorPeriod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxDigitalOptionSequence0")
		public FxDigitalOption.FxDigitalOptionBuilder setFxDigitalOptionSequence0(FxDigitalOptionSequence0 fxDigitalOptionSequence0) {
			this.fxDigitalOptionSequence0 = fxDigitalOptionSequence0==null?null:fxDigitalOptionSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxDigitalOptionSequence1")
		public FxDigitalOption.FxDigitalOptionBuilder setFxDigitalOptionSequence1(FxDigitalOptionSequence1 fxDigitalOptionSequence1) {
			this.fxDigitalOptionSequence1 = fxDigitalOptionSequence1==null?null:fxDigitalOptionSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public FxDigitalOption.FxDigitalOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payout")
		public FxDigitalOption.FxDigitalOptionBuilder setPayout(FxOptionPayout payout) {
			this.payout = payout==null?null:payout.toBuilder();
			return this;
		}
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addPremium(FxOptionPremium premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addPremium(FxOptionPremium premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public FxDigitalOption.FxDigitalOptionBuilder addPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums != null) {
				for (FxOptionPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("premium")
		public FxDigitalOption.FxDigitalOptionBuilder setPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums == null)  {
				this.premium = new ArrayList<>();
			}
			else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxDigitalOption build() {
			return new FxDigitalOption.FxDigitalOptionImpl(this);
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder prune() {
			super.prune();
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			if (fxDigitalOptionSequence0!=null && !fxDigitalOptionSequence0.prune().hasData()) fxDigitalOptionSequence0 = null;
			if (fxDigitalOptionSequence1!=null && !fxDigitalOptionSequence1.prune().hasData()) fxDigitalOptionSequence1 = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (payout!=null && !payout.prune().hasData()) payout = null;
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			if (getFxDigitalOptionSequence0()!=null && getFxDigitalOptionSequence0().hasData()) return true;
			if (getFxDigitalOptionSequence1()!=null && getFxDigitalOptionSequence1().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getPayout()!=null && getPayout().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxDigitalOption.FxDigitalOptionBuilder o = (FxDigitalOption.FxDigitalOptionBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			merger.mergeRosetta(getFxDigitalOptionSequence0(), o.getFxDigitalOptionSequence0(), this::setFxDigitalOptionSequence0);
			merger.mergeRosetta(getFxDigitalOptionSequence1(), o.getFxDigitalOptionSequence1(), this::setFxDigitalOptionSequence1);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getPayout(), o.getPayout(), this::setPayout);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(fxDigitalOptionSequence0, _that.getFxDigitalOptionSequence0())) return false;
			if (!Objects.equals(fxDigitalOptionSequence1, _that.getFxDigitalOptionSequence1())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (fxDigitalOptionSequence0 != null ? fxDigitalOptionSequence0.hashCode() : 0);
			_result = 31 * _result + (fxDigitalOptionSequence1 != null ? fxDigitalOptionSequence1.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalOptionBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"fxDigitalOptionSequence0=" + this.fxDigitalOptionSequence0 + ", " +
				"fxDigitalOptionSequence1=" + this.fxDigitalOptionSequence1 + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"payout=" + this.payout + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}
}
