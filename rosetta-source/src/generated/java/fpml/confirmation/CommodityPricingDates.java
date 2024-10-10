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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommodityPricingDates.CommodityPricingDatesBuilder;
import fpml.confirmation.CommodityPricingDates.CommodityPricingDatesBuilderImpl;
import fpml.confirmation.CommodityPricingDates.CommodityPricingDatesImpl;
import fpml.confirmation.CommodityPricingDatesSequence;
import fpml.confirmation.meta.CommodityPricingDatesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The dates on which prices are observed for the underlyer.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPricingDates", builder=CommodityPricingDates.CommodityPricingDatesBuilderImpl.class, version="${project.version}")
public interface CommodityPricingDates extends RosettaModelObject {

	CommodityPricingDatesMeta metaData = new CommodityPricingDatesMeta();

	/*********************** Getter Methods  ***********************/
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();
	CommodityPricingDatesSequence getCommodityPricingDatesSequence();
	/**
	 * A list of adjustable dates on which the trade will price. Each date will price for the Calculation Period within which it falls.
	 */
	List<? extends AdjustableDates> getPricingDates();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityPricingDates build();
	
	CommodityPricingDates.CommodityPricingDatesBuilder toBuilder();
	
	static CommodityPricingDates.CommodityPricingDatesBuilder builder() {
		return new CommodityPricingDates.CommodityPricingDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPricingDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPricingDates> getType() {
		return CommodityPricingDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
		processRosetta(path.newSubPath("commodityPricingDatesSequence"), processor, CommodityPricingDatesSequence.class, getCommodityPricingDatesSequence());
		processRosetta(path.newSubPath("pricingDates"), processor, AdjustableDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPricingDatesBuilder extends CommodityPricingDates, RosettaModelObjectBuilder {
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder getOrCreateCommodityPricingDatesSequence();
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder getCommodityPricingDatesSequence();
		AdjustableDates.AdjustableDatesBuilder getOrCreatePricingDates(int _index);
		List<? extends AdjustableDates.AdjustableDatesBuilder> getPricingDates();
		CommodityPricingDates.CommodityPricingDatesBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);
		CommodityPricingDates.CommodityPricingDatesBuilder setCommodityPricingDatesSequence(CommodityPricingDatesSequence commodityPricingDatesSequence);
		CommodityPricingDates.CommodityPricingDatesBuilder addPricingDates(AdjustableDates pricingDates0);
		CommodityPricingDates.CommodityPricingDatesBuilder addPricingDates(AdjustableDates pricingDates1, int _idx);
		CommodityPricingDates.CommodityPricingDatesBuilder addPricingDates(List<? extends AdjustableDates> pricingDates2);
		CommodityPricingDates.CommodityPricingDatesBuilder setPricingDates(List<? extends AdjustableDates> pricingDates3);
		CommodityPricingDates.CommodityPricingDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
			processRosetta(path.newSubPath("commodityPricingDatesSequence"), processor, CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder.class, getCommodityPricingDatesSequence());
			processRosetta(path.newSubPath("pricingDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityPricingDates.CommodityPricingDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPricingDates  ***********************/
	class CommodityPricingDatesImpl implements CommodityPricingDates {
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		private final CommodityPricingDatesSequence commodityPricingDatesSequence;
		private final List<? extends AdjustableDates> pricingDates;
		private final String id;
		
		protected CommodityPricingDatesImpl(CommodityPricingDates.CommodityPricingDatesBuilder builder) {
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
			this.commodityPricingDatesSequence = ofNullable(builder.getCommodityPricingDatesSequence()).map(f->f.build()).orElse(null);
			this.pricingDates = ofNullable(builder.getPricingDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		@RosettaAttribute("commodityPricingDatesSequence")
		public CommodityPricingDatesSequence getCommodityPricingDatesSequence() {
			return commodityPricingDatesSequence;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public List<? extends AdjustableDates> getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityPricingDates build() {
			return this;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder toBuilder() {
			CommodityPricingDates.CommodityPricingDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPricingDates.CommodityPricingDatesBuilder builder) {
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
			ofNullable(getCommodityPricingDatesSequence()).ifPresent(builder::setCommodityPricingDatesSequence);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPricingDates _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(commodityPricingDatesSequence, _that.getCommodityPricingDatesSequence())) return false;
			if (!ListEquals.listEquals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (commodityPricingDatesSequence != null ? commodityPricingDatesSequence.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPricingDates {" +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"commodityPricingDatesSequence=" + this.commodityPricingDatesSequence + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPricingDates  ***********************/
	class CommodityPricingDatesBuilderImpl implements CommodityPricingDates.CommodityPricingDatesBuilder {
	
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
		protected CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder commodityPricingDatesSequence;
		protected List<AdjustableDates.AdjustableDatesBuilder> pricingDates = new ArrayList<>();
		protected String id;
	
		public CommodityPricingDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel() {
			CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder result;
			if (commodityCalculationPeriodsPointerModel!=null) {
				result = commodityCalculationPeriodsPointerModel;
			}
			else {
				result = commodityCalculationPeriodsPointerModel = CommodityCalculationPeriodsPointerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPricingDatesSequence")
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder getCommodityPricingDatesSequence() {
			return commodityPricingDatesSequence;
		}
		
		@Override
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder getOrCreateCommodityPricingDatesSequence() {
			CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder result;
			if (commodityPricingDatesSequence!=null) {
				result = commodityPricingDatesSequence;
			}
			else {
				result = commodityPricingDatesSequence = CommodityPricingDatesSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public List<? extends AdjustableDates.AdjustableDatesBuilder> getPricingDates() {
			return pricingDates;
		}
		
		public AdjustableDates.AdjustableDatesBuilder getOrCreatePricingDates(int _index) {
		
			if (pricingDates==null) {
				this.pricingDates = new ArrayList<>();
			}
			AdjustableDates.AdjustableDatesBuilder result;
			return getIndex(pricingDates, _index, () -> {
						AdjustableDates.AdjustableDatesBuilder newPricingDates = AdjustableDates.builder();
						return newPricingDates;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityPricingDates.CommodityPricingDatesBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPricingDatesSequence")
		public CommodityPricingDates.CommodityPricingDatesBuilder setCommodityPricingDatesSequence(CommodityPricingDatesSequence commodityPricingDatesSequence) {
			this.commodityPricingDatesSequence = commodityPricingDatesSequence==null?null:commodityPricingDatesSequence.toBuilder();
			return this;
		}
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder addPricingDates(AdjustableDates pricingDates) {
			if (pricingDates!=null) this.pricingDates.add(pricingDates.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder addPricingDates(AdjustableDates pricingDates, int _idx) {
			getIndex(this.pricingDates, _idx, () -> pricingDates.toBuilder());
			return this;
		}
		@Override 
		public CommodityPricingDates.CommodityPricingDatesBuilder addPricingDates(List<? extends AdjustableDates> pricingDatess) {
			if (pricingDatess != null) {
				for (AdjustableDates toAdd : pricingDatess) {
					this.pricingDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates.CommodityPricingDatesBuilder setPricingDates(List<? extends AdjustableDates> pricingDatess) {
			if (pricingDatess == null)  {
				this.pricingDates = new ArrayList<>();
			}
			else {
				this.pricingDates = pricingDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityPricingDates.CommodityPricingDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityPricingDates build() {
			return new CommodityPricingDates.CommodityPricingDatesImpl(this);
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder prune() {
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			if (commodityPricingDatesSequence!=null && !commodityPricingDatesSequence.prune().hasData()) commodityPricingDatesSequence = null;
			pricingDates = pricingDates.stream().filter(b->b!=null).<AdjustableDates.AdjustableDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			if (getCommodityPricingDatesSequence()!=null && getCommodityPricingDatesSequence().hasData()) return true;
			if (getPricingDates()!=null && getPricingDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPricingDates.CommodityPricingDatesBuilder o = (CommodityPricingDates.CommodityPricingDatesBuilder) other;
			
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			merger.mergeRosetta(getCommodityPricingDatesSequence(), o.getCommodityPricingDatesSequence(), this::setCommodityPricingDatesSequence);
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::getOrCreatePricingDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPricingDates _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(commodityPricingDatesSequence, _that.getCommodityPricingDatesSequence())) return false;
			if (!ListEquals.listEquals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (commodityPricingDatesSequence != null ? commodityPricingDatesSequence.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPricingDatesBuilder {" +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"commodityPricingDatesSequence=" + this.commodityPricingDatesSequence + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
