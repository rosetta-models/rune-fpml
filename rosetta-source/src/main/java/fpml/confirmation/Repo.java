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
import fpml.confirmation.BondEquityModel;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.InitialMargin;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Repo;
import fpml.confirmation.Repo.RepoBuilder;
import fpml.confirmation.Repo.RepoBuilderImpl;
import fpml.confirmation.Repo.RepoImpl;
import fpml.confirmation.RepoDurationEnum;
import fpml.confirmation.RepoFarLeg;
import fpml.confirmation.RepoNearLeg;
import fpml.confirmation.RepoSequence;
import fpml.confirmation.Schedule;
import fpml.confirmation.TriParty;
import fpml.confirmation.meta.RepoMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Global element representing a Repo. A Repo, modeled as an FpML:Product. Note: this Repo model is a candidate model for further industry input.
 * @version ${project.version}
 */
@RosettaDataType(value="Repo", builder=Repo.RepoBuilderImpl.class, version="${project.version}")
public interface Repo extends Product {

	RepoMeta metaData = new RepoMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The fixed repo rate. It is usually fixed for the duration of the agreement but can be changed with mid-life events (rate changes) except for sell/buy-back trades.
	 */
	Schedule getFixedRateSchedule();
	/**
	 * The floating rate index and tenor, with additional definitions relating to the calculation of floating rate amounts, including spread and multiplier. It is used for floating rate repos. For example, floating rate repos on European markets are made against EONIA.
	 */
	FloatingRateCalculation getFloatingRateCalculation();
	/**
	 * The day count fraction.
	 */
	DayCountFraction getDayCountFraction();
	/**
	 * A duration code for the repo transaction. This defines a type of a repo transaction with fixed duration.
	 */
	RepoDurationEnum getDuration();
	RepoSequence getRepoSequence();
	/**
	 * Defines initial margin applied to a repo transaction.
	 */
	InitialMargin getInitialMargin();
	/**
	 * A repo contract is modeled as two purchase/repurchase transactions which are called legs. This is the near leg, i.e. the transaction that will be executed on the near settlement date of the contract.
	 */
	RepoNearLeg getNearLeg();
	/**
	 * The far leg of the repo contract, i.e. the repurchase transaction. The BuyerSeller model in the far leg must be the exact opposite of the one found in the near leg.
	 */
	RepoFarLeg getFarLeg();
	List<? extends BondEquityModel> getBondEquityModel();
	TriParty getTriParty();

	/*********************** Build Methods  ***********************/
	Repo build();
	
	Repo.RepoBuilder toBuilder();
	
	static Repo.RepoBuilder builder() {
		return new Repo.RepoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Repo> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Repo> getType() {
		return Repo.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.class, getFixedRateSchedule());
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("duration"), RepoDurationEnum.class, getDuration(), this);
		processRosetta(path.newSubPath("repoSequence"), processor, RepoSequence.class, getRepoSequence());
		processRosetta(path.newSubPath("initialMargin"), processor, InitialMargin.class, getInitialMargin());
		processRosetta(path.newSubPath("nearLeg"), processor, RepoNearLeg.class, getNearLeg());
		processRosetta(path.newSubPath("farLeg"), processor, RepoFarLeg.class, getFarLeg());
		processRosetta(path.newSubPath("bondEquityModel"), processor, BondEquityModel.class, getBondEquityModel());
		processRosetta(path.newSubPath("triParty"), processor, TriParty.class, getTriParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoBuilder extends Repo, Product.ProductBuilder {
		Schedule.ScheduleBuilder getOrCreateFixedRateSchedule();
		Schedule.ScheduleBuilder getFixedRateSchedule();
		FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation();
		FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		RepoSequence.RepoSequenceBuilder getOrCreateRepoSequence();
		RepoSequence.RepoSequenceBuilder getRepoSequence();
		InitialMargin.InitialMarginBuilder getOrCreateInitialMargin();
		InitialMargin.InitialMarginBuilder getInitialMargin();
		RepoNearLeg.RepoNearLegBuilder getOrCreateNearLeg();
		RepoNearLeg.RepoNearLegBuilder getNearLeg();
		RepoFarLeg.RepoFarLegBuilder getOrCreateFarLeg();
		RepoFarLeg.RepoFarLegBuilder getFarLeg();
		BondEquityModel.BondEquityModelBuilder getOrCreateBondEquityModel(int _index);
		List<? extends BondEquityModel.BondEquityModelBuilder> getBondEquityModel();
		TriParty.TriPartyBuilder getOrCreateTriParty();
		TriParty.TriPartyBuilder getTriParty();
		Repo.RepoBuilder setProductModel(ProductModel productModel);
		Repo.RepoBuilder setId(String id);
		Repo.RepoBuilder setFixedRateSchedule(Schedule fixedRateSchedule);
		Repo.RepoBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		Repo.RepoBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		Repo.RepoBuilder setDuration(RepoDurationEnum duration);
		Repo.RepoBuilder setRepoSequence(RepoSequence repoSequence);
		Repo.RepoBuilder setInitialMargin(InitialMargin initialMargin);
		Repo.RepoBuilder setNearLeg(RepoNearLeg nearLeg);
		Repo.RepoBuilder setFarLeg(RepoFarLeg farLeg);
		Repo.RepoBuilder addBondEquityModel(BondEquityModel bondEquityModel0);
		Repo.RepoBuilder addBondEquityModel(BondEquityModel bondEquityModel1, int _idx);
		Repo.RepoBuilder addBondEquityModel(List<? extends BondEquityModel> bondEquityModel2);
		Repo.RepoBuilder setBondEquityModel(List<? extends BondEquityModel> bondEquityModel3);
		Repo.RepoBuilder setTriParty(TriParty triParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFixedRateSchedule());
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("duration"), RepoDurationEnum.class, getDuration(), this);
			processRosetta(path.newSubPath("repoSequence"), processor, RepoSequence.RepoSequenceBuilder.class, getRepoSequence());
			processRosetta(path.newSubPath("initialMargin"), processor, InitialMargin.InitialMarginBuilder.class, getInitialMargin());
			processRosetta(path.newSubPath("nearLeg"), processor, RepoNearLeg.RepoNearLegBuilder.class, getNearLeg());
			processRosetta(path.newSubPath("farLeg"), processor, RepoFarLeg.RepoFarLegBuilder.class, getFarLeg());
			processRosetta(path.newSubPath("bondEquityModel"), processor, BondEquityModel.BondEquityModelBuilder.class, getBondEquityModel());
			processRosetta(path.newSubPath("triParty"), processor, TriParty.TriPartyBuilder.class, getTriParty());
		}
		

		Repo.RepoBuilder prune();
	}

	/*********************** Immutable Implementation of Repo  ***********************/
	class RepoImpl extends Product.ProductImpl implements Repo {
		private final Schedule fixedRateSchedule;
		private final FloatingRateCalculation floatingRateCalculation;
		private final DayCountFraction dayCountFraction;
		private final RepoDurationEnum duration;
		private final RepoSequence repoSequence;
		private final InitialMargin initialMargin;
		private final RepoNearLeg nearLeg;
		private final RepoFarLeg farLeg;
		private final List<? extends BondEquityModel> bondEquityModel;
		private final TriParty triParty;
		
		protected RepoImpl(Repo.RepoBuilder builder) {
			super(builder);
			this.fixedRateSchedule = ofNullable(builder.getFixedRateSchedule()).map(f->f.build()).orElse(null);
			this.floatingRateCalculation = ofNullable(builder.getFloatingRateCalculation()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.duration = builder.getDuration();
			this.repoSequence = ofNullable(builder.getRepoSequence()).map(f->f.build()).orElse(null);
			this.initialMargin = ofNullable(builder.getInitialMargin()).map(f->f.build()).orElse(null);
			this.nearLeg = ofNullable(builder.getNearLeg()).map(f->f.build()).orElse(null);
			this.farLeg = ofNullable(builder.getFarLeg()).map(f->f.build()).orElse(null);
			this.bondEquityModel = ofNullable(builder.getBondEquityModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.triParty = ofNullable(builder.getTriParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		public Schedule getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		public FloatingRateCalculation getFloatingRateCalculation() {
			return floatingRateCalculation;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("duration")
		public RepoDurationEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("repoSequence")
		public RepoSequence getRepoSequence() {
			return repoSequence;
		}
		
		@Override
		@RosettaAttribute("initialMargin")
		public InitialMargin getInitialMargin() {
			return initialMargin;
		}
		
		@Override
		@RosettaAttribute("nearLeg")
		public RepoNearLeg getNearLeg() {
			return nearLeg;
		}
		
		@Override
		@RosettaAttribute("farLeg")
		public RepoFarLeg getFarLeg() {
			return farLeg;
		}
		
		@Override
		@RosettaAttribute("bondEquityModel")
		public List<? extends BondEquityModel> getBondEquityModel() {
			return bondEquityModel;
		}
		
		@Override
		@RosettaAttribute("triParty")
		public TriParty getTriParty() {
			return triParty;
		}
		
		@Override
		public Repo build() {
			return this;
		}
		
		@Override
		public Repo.RepoBuilder toBuilder() {
			Repo.RepoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Repo.RepoBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedRateSchedule()).ifPresent(builder::setFixedRateSchedule);
			ofNullable(getFloatingRateCalculation()).ifPresent(builder::setFloatingRateCalculation);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getDuration()).ifPresent(builder::setDuration);
			ofNullable(getRepoSequence()).ifPresent(builder::setRepoSequence);
			ofNullable(getInitialMargin()).ifPresent(builder::setInitialMargin);
			ofNullable(getNearLeg()).ifPresent(builder::setNearLeg);
			ofNullable(getFarLeg()).ifPresent(builder::setFarLeg);
			ofNullable(getBondEquityModel()).ifPresent(builder::setBondEquityModel);
			ofNullable(getTriParty()).ifPresent(builder::setTriParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Repo _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!Objects.equals(repoSequence, _that.getRepoSequence())) return false;
			if (!Objects.equals(initialMargin, _that.getInitialMargin())) return false;
			if (!Objects.equals(nearLeg, _that.getNearLeg())) return false;
			if (!Objects.equals(farLeg, _that.getFarLeg())) return false;
			if (!ListEquals.listEquals(bondEquityModel, _that.getBondEquityModel())) return false;
			if (!Objects.equals(triParty, _that.getTriParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (repoSequence != null ? repoSequence.hashCode() : 0);
			_result = 31 * _result + (initialMargin != null ? initialMargin.hashCode() : 0);
			_result = 31 * _result + (nearLeg != null ? nearLeg.hashCode() : 0);
			_result = 31 * _result + (farLeg != null ? farLeg.hashCode() : 0);
			_result = 31 * _result + (bondEquityModel != null ? bondEquityModel.hashCode() : 0);
			_result = 31 * _result + (triParty != null ? triParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Repo {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"duration=" + this.duration + ", " +
				"repoSequence=" + this.repoSequence + ", " +
				"initialMargin=" + this.initialMargin + ", " +
				"nearLeg=" + this.nearLeg + ", " +
				"farLeg=" + this.farLeg + ", " +
				"bondEquityModel=" + this.bondEquityModel + ", " +
				"triParty=" + this.triParty +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Repo  ***********************/
	class RepoBuilderImpl extends Product.ProductBuilderImpl  implements Repo.RepoBuilder {
	
		protected Schedule.ScheduleBuilder fixedRateSchedule;
		protected FloatingRateCalculation.FloatingRateCalculationBuilder floatingRateCalculation;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected RepoDurationEnum duration;
		protected RepoSequence.RepoSequenceBuilder repoSequence;
		protected InitialMargin.InitialMarginBuilder initialMargin;
		protected RepoNearLeg.RepoNearLegBuilder nearLeg;
		protected RepoFarLeg.RepoFarLegBuilder farLeg;
		protected List<BondEquityModel.BondEquityModelBuilder> bondEquityModel = new ArrayList<>();
		protected TriParty.TriPartyBuilder triParty;
	
		public RepoBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedRateSchedule")
		public Schedule.ScheduleBuilder getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFixedRateSchedule() {
			Schedule.ScheduleBuilder result;
			if (fixedRateSchedule!=null) {
				result = fixedRateSchedule;
			}
			else {
				result = fixedRateSchedule = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		public FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation() {
			return floatingRateCalculation;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation() {
			FloatingRateCalculation.FloatingRateCalculationBuilder result;
			if (floatingRateCalculation!=null) {
				result = floatingRateCalculation;
			}
			else {
				result = floatingRateCalculation = FloatingRateCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("duration")
		public RepoDurationEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("repoSequence")
		public RepoSequence.RepoSequenceBuilder getRepoSequence() {
			return repoSequence;
		}
		
		@Override
		public RepoSequence.RepoSequenceBuilder getOrCreateRepoSequence() {
			RepoSequence.RepoSequenceBuilder result;
			if (repoSequence!=null) {
				result = repoSequence;
			}
			else {
				result = repoSequence = RepoSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialMargin")
		public InitialMargin.InitialMarginBuilder getInitialMargin() {
			return initialMargin;
		}
		
		@Override
		public InitialMargin.InitialMarginBuilder getOrCreateInitialMargin() {
			InitialMargin.InitialMarginBuilder result;
			if (initialMargin!=null) {
				result = initialMargin;
			}
			else {
				result = initialMargin = InitialMargin.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nearLeg")
		public RepoNearLeg.RepoNearLegBuilder getNearLeg() {
			return nearLeg;
		}
		
		@Override
		public RepoNearLeg.RepoNearLegBuilder getOrCreateNearLeg() {
			RepoNearLeg.RepoNearLegBuilder result;
			if (nearLeg!=null) {
				result = nearLeg;
			}
			else {
				result = nearLeg = RepoNearLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("farLeg")
		public RepoFarLeg.RepoFarLegBuilder getFarLeg() {
			return farLeg;
		}
		
		@Override
		public RepoFarLeg.RepoFarLegBuilder getOrCreateFarLeg() {
			RepoFarLeg.RepoFarLegBuilder result;
			if (farLeg!=null) {
				result = farLeg;
			}
			else {
				result = farLeg = RepoFarLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bondEquityModel")
		public List<? extends BondEquityModel.BondEquityModelBuilder> getBondEquityModel() {
			return bondEquityModel;
		}
		
		public BondEquityModel.BondEquityModelBuilder getOrCreateBondEquityModel(int _index) {
		
			if (bondEquityModel==null) {
				this.bondEquityModel = new ArrayList<>();
			}
			BondEquityModel.BondEquityModelBuilder result;
			return getIndex(bondEquityModel, _index, () -> {
						BondEquityModel.BondEquityModelBuilder newBondEquityModel = BondEquityModel.builder();
						return newBondEquityModel;
					});
		}
		
		@Override
		@RosettaAttribute("triParty")
		public TriParty.TriPartyBuilder getTriParty() {
			return triParty;
		}
		
		@Override
		public TriParty.TriPartyBuilder getOrCreateTriParty() {
			TriParty.TriPartyBuilder result;
			if (triParty!=null) {
				result = triParty;
			}
			else {
				result = triParty = TriParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public Repo.RepoBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Repo.RepoBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fixedRateSchedule")
		public Repo.RepoBuilder setFixedRateSchedule(Schedule fixedRateSchedule) {
			this.fixedRateSchedule = fixedRateSchedule==null?null:fixedRateSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateCalculation")
		public Repo.RepoBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation) {
			this.floatingRateCalculation = floatingRateCalculation==null?null:floatingRateCalculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public Repo.RepoBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("duration")
		public Repo.RepoBuilder setDuration(RepoDurationEnum duration) {
			this.duration = duration==null?null:duration;
			return this;
		}
		@Override
		@RosettaAttribute("repoSequence")
		public Repo.RepoBuilder setRepoSequence(RepoSequence repoSequence) {
			this.repoSequence = repoSequence==null?null:repoSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialMargin")
		public Repo.RepoBuilder setInitialMargin(InitialMargin initialMargin) {
			this.initialMargin = initialMargin==null?null:initialMargin.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("nearLeg")
		public Repo.RepoBuilder setNearLeg(RepoNearLeg nearLeg) {
			this.nearLeg = nearLeg==null?null:nearLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("farLeg")
		public Repo.RepoBuilder setFarLeg(RepoFarLeg farLeg) {
			this.farLeg = farLeg==null?null:farLeg.toBuilder();
			return this;
		}
		@Override
		public Repo.RepoBuilder addBondEquityModel(BondEquityModel bondEquityModel) {
			if (bondEquityModel!=null) this.bondEquityModel.add(bondEquityModel.toBuilder());
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addBondEquityModel(BondEquityModel bondEquityModel, int _idx) {
			getIndex(this.bondEquityModel, _idx, () -> bondEquityModel.toBuilder());
			return this;
		}
		@Override 
		public Repo.RepoBuilder addBondEquityModel(List<? extends BondEquityModel> bondEquityModels) {
			if (bondEquityModels != null) {
				for (BondEquityModel toAdd : bondEquityModels) {
					this.bondEquityModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("bondEquityModel")
		public Repo.RepoBuilder setBondEquityModel(List<? extends BondEquityModel> bondEquityModels) {
			if (bondEquityModels == null)  {
				this.bondEquityModel = new ArrayList<>();
			}
			else {
				this.bondEquityModel = bondEquityModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("triParty")
		public Repo.RepoBuilder setTriParty(TriParty triParty) {
			this.triParty = triParty==null?null:triParty.toBuilder();
			return this;
		}
		
		@Override
		public Repo build() {
			return new Repo.RepoImpl(this);
		}
		
		@Override
		public Repo.RepoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Repo.RepoBuilder prune() {
			super.prune();
			if (fixedRateSchedule!=null && !fixedRateSchedule.prune().hasData()) fixedRateSchedule = null;
			if (floatingRateCalculation!=null && !floatingRateCalculation.prune().hasData()) floatingRateCalculation = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (repoSequence!=null && !repoSequence.prune().hasData()) repoSequence = null;
			if (initialMargin!=null && !initialMargin.prune().hasData()) initialMargin = null;
			if (nearLeg!=null && !nearLeg.prune().hasData()) nearLeg = null;
			if (farLeg!=null && !farLeg.prune().hasData()) farLeg = null;
			bondEquityModel = bondEquityModel.stream().filter(b->b!=null).<BondEquityModel.BondEquityModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (triParty!=null && !triParty.prune().hasData()) triParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedRateSchedule()!=null && getFixedRateSchedule().hasData()) return true;
			if (getFloatingRateCalculation()!=null && getFloatingRateCalculation().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getDuration()!=null) return true;
			if (getRepoSequence()!=null && getRepoSequence().hasData()) return true;
			if (getInitialMargin()!=null && getInitialMargin().hasData()) return true;
			if (getNearLeg()!=null && getNearLeg().hasData()) return true;
			if (getFarLeg()!=null && getFarLeg().hasData()) return true;
			if (getBondEquityModel()!=null && getBondEquityModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTriParty()!=null && getTriParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Repo.RepoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Repo.RepoBuilder o = (Repo.RepoBuilder) other;
			
			merger.mergeRosetta(getFixedRateSchedule(), o.getFixedRateSchedule(), this::setFixedRateSchedule);
			merger.mergeRosetta(getFloatingRateCalculation(), o.getFloatingRateCalculation(), this::setFloatingRateCalculation);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getRepoSequence(), o.getRepoSequence(), this::setRepoSequence);
			merger.mergeRosetta(getInitialMargin(), o.getInitialMargin(), this::setInitialMargin);
			merger.mergeRosetta(getNearLeg(), o.getNearLeg(), this::setNearLeg);
			merger.mergeRosetta(getFarLeg(), o.getFarLeg(), this::setFarLeg);
			merger.mergeRosetta(getBondEquityModel(), o.getBondEquityModel(), this::getOrCreateBondEquityModel);
			merger.mergeRosetta(getTriParty(), o.getTriParty(), this::setTriParty);
			
			merger.mergeBasic(getDuration(), o.getDuration(), this::setDuration);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Repo _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!Objects.equals(repoSequence, _that.getRepoSequence())) return false;
			if (!Objects.equals(initialMargin, _that.getInitialMargin())) return false;
			if (!Objects.equals(nearLeg, _that.getNearLeg())) return false;
			if (!Objects.equals(farLeg, _that.getFarLeg())) return false;
			if (!ListEquals.listEquals(bondEquityModel, _that.getBondEquityModel())) return false;
			if (!Objects.equals(triParty, _that.getTriParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (repoSequence != null ? repoSequence.hashCode() : 0);
			_result = 31 * _result + (initialMargin != null ? initialMargin.hashCode() : 0);
			_result = 31 * _result + (nearLeg != null ? nearLeg.hashCode() : 0);
			_result = 31 * _result + (farLeg != null ? farLeg.hashCode() : 0);
			_result = 31 * _result + (bondEquityModel != null ? bondEquityModel.hashCode() : 0);
			_result = 31 * _result + (triParty != null ? triParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoBuilder {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"duration=" + this.duration + ", " +
				"repoSequence=" + this.repoSequence + ", " +
				"initialMargin=" + this.initialMargin + ", " +
				"nearLeg=" + this.nearLeg + ", " +
				"farLeg=" + this.farLeg + ", " +
				"bondEquityModel=" + this.bondEquityModel + ", " +
				"triParty=" + this.triParty +
			'}' + " " + super.toString();
		}
	}
}
