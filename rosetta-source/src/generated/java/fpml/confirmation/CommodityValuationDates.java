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
import fpml.confirmation.CommodityValuationDates;
import fpml.confirmation.CommodityValuationDates.CommodityValuationDatesBuilder;
import fpml.confirmation.CommodityValuationDates.CommodityValuationDatesBuilderImpl;
import fpml.confirmation.CommodityValuationDates.CommodityValuationDatesImpl;
import fpml.confirmation.CommodityValuationDatesSequence;
import fpml.confirmation.meta.CommodityValuationDatesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The dates on which prices are observed for the underlyer.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityValuationDates", builder=CommodityValuationDates.CommodityValuationDatesBuilderImpl.class, version="${project.version}")
public interface CommodityValuationDates extends RosettaModelObject {

	CommodityValuationDatesMeta metaData = new CommodityValuationDatesMeta();

	/*********************** Getter Methods  ***********************/
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();
	CommodityValuationDatesSequence getCommodityValuationDatesSequence();
	/**
	 * A list of adjustable dates on which the trade will price. Each date will price for the Calculation Period within which it falls.
	 */
	List<? extends AdjustableDates> getValuationDates();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityValuationDates build();
	
	CommodityValuationDates.CommodityValuationDatesBuilder toBuilder();
	
	static CommodityValuationDates.CommodityValuationDatesBuilder builder() {
		return new CommodityValuationDates.CommodityValuationDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityValuationDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityValuationDates> getType() {
		return CommodityValuationDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
		processRosetta(path.newSubPath("commodityValuationDatesSequence"), processor, CommodityValuationDatesSequence.class, getCommodityValuationDatesSequence());
		processRosetta(path.newSubPath("valuationDates"), processor, AdjustableDates.class, getValuationDates());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityValuationDatesBuilder extends CommodityValuationDates, RosettaModelObjectBuilder {
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder getOrCreateCommodityValuationDatesSequence();
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder getCommodityValuationDatesSequence();
		AdjustableDates.AdjustableDatesBuilder getOrCreateValuationDates(int _index);
		List<? extends AdjustableDates.AdjustableDatesBuilder> getValuationDates();
		CommodityValuationDates.CommodityValuationDatesBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);
		CommodityValuationDates.CommodityValuationDatesBuilder setCommodityValuationDatesSequence(CommodityValuationDatesSequence commodityValuationDatesSequence);
		CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(AdjustableDates valuationDates0);
		CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(AdjustableDates valuationDates1, int _idx);
		CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(List<? extends AdjustableDates> valuationDates2);
		CommodityValuationDates.CommodityValuationDatesBuilder setValuationDates(List<? extends AdjustableDates> valuationDates3);
		CommodityValuationDates.CommodityValuationDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
			processRosetta(path.newSubPath("commodityValuationDatesSequence"), processor, CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder.class, getCommodityValuationDatesSequence());
			processRosetta(path.newSubPath("valuationDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getValuationDates());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityValuationDates.CommodityValuationDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityValuationDates  ***********************/
	class CommodityValuationDatesImpl implements CommodityValuationDates {
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		private final CommodityValuationDatesSequence commodityValuationDatesSequence;
		private final List<? extends AdjustableDates> valuationDates;
		private final String id;
		
		protected CommodityValuationDatesImpl(CommodityValuationDates.CommodityValuationDatesBuilder builder) {
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
			this.commodityValuationDatesSequence = ofNullable(builder.getCommodityValuationDatesSequence()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		@RosettaAttribute("commodityValuationDatesSequence")
		public CommodityValuationDatesSequence getCommodityValuationDatesSequence() {
			return commodityValuationDatesSequence;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		public List<? extends AdjustableDates> getValuationDates() {
			return valuationDates;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityValuationDates build() {
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder toBuilder() {
			CommodityValuationDates.CommodityValuationDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityValuationDates.CommodityValuationDatesBuilder builder) {
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
			ofNullable(getCommodityValuationDatesSequence()).ifPresent(builder::setCommodityValuationDatesSequence);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityValuationDates _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(commodityValuationDatesSequence, _that.getCommodityValuationDatesSequence())) return false;
			if (!ListEquals.listEquals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (commodityValuationDatesSequence != null ? commodityValuationDatesSequence.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityValuationDates {" +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"commodityValuationDatesSequence=" + this.commodityValuationDatesSequence + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityValuationDates  ***********************/
	class CommodityValuationDatesBuilderImpl implements CommodityValuationDates.CommodityValuationDatesBuilder {
	
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
		protected CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder commodityValuationDatesSequence;
		protected List<AdjustableDates.AdjustableDatesBuilder> valuationDates = new ArrayList<>();
		protected String id;
	
		public CommodityValuationDatesBuilderImpl() {
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
		@RosettaAttribute("commodityValuationDatesSequence")
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder getCommodityValuationDatesSequence() {
			return commodityValuationDatesSequence;
		}
		
		@Override
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder getOrCreateCommodityValuationDatesSequence() {
			CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder result;
			if (commodityValuationDatesSequence!=null) {
				result = commodityValuationDatesSequence;
			}
			else {
				result = commodityValuationDatesSequence = CommodityValuationDatesSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		public List<? extends AdjustableDates.AdjustableDatesBuilder> getValuationDates() {
			return valuationDates;
		}
		
		public AdjustableDates.AdjustableDatesBuilder getOrCreateValuationDates(int _index) {
		
			if (valuationDates==null) {
				this.valuationDates = new ArrayList<>();
			}
			AdjustableDates.AdjustableDatesBuilder result;
			return getIndex(valuationDates, _index, () -> {
						AdjustableDates.AdjustableDatesBuilder newValuationDates = AdjustableDates.builder();
						return newValuationDates;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityValuationDates.CommodityValuationDatesBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityValuationDatesSequence")
		public CommodityValuationDates.CommodityValuationDatesBuilder setCommodityValuationDatesSequence(CommodityValuationDatesSequence commodityValuationDatesSequence) {
			this.commodityValuationDatesSequence = commodityValuationDatesSequence==null?null:commodityValuationDatesSequence.toBuilder();
			return this;
		}
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(AdjustableDates valuationDates) {
			if (valuationDates!=null) this.valuationDates.add(valuationDates.toBuilder());
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(AdjustableDates valuationDates, int _idx) {
			getIndex(this.valuationDates, _idx, () -> valuationDates.toBuilder());
			return this;
		}
		@Override 
		public CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(List<? extends AdjustableDates> valuationDatess) {
			if (valuationDatess != null) {
				for (AdjustableDates toAdd : valuationDatess) {
					this.valuationDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("valuationDates")
		public CommodityValuationDates.CommodityValuationDatesBuilder setValuationDates(List<? extends AdjustableDates> valuationDatess) {
			if (valuationDatess == null)  {
				this.valuationDates = new ArrayList<>();
			}
			else {
				this.valuationDates = valuationDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityValuationDates.CommodityValuationDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityValuationDates build() {
			return new CommodityValuationDates.CommodityValuationDatesImpl(this);
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder prune() {
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			if (commodityValuationDatesSequence!=null && !commodityValuationDatesSequence.prune().hasData()) commodityValuationDatesSequence = null;
			valuationDates = valuationDates.stream().filter(b->b!=null).<AdjustableDates.AdjustableDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			if (getCommodityValuationDatesSequence()!=null && getCommodityValuationDatesSequence().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityValuationDates.CommodityValuationDatesBuilder o = (CommodityValuationDates.CommodityValuationDatesBuilder) other;
			
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			merger.mergeRosetta(getCommodityValuationDatesSequence(), o.getCommodityValuationDatesSequence(), this::setCommodityValuationDatesSequence);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::getOrCreateValuationDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityValuationDates _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(commodityValuationDatesSequence, _that.getCommodityValuationDatesSequence())) return false;
			if (!ListEquals.listEquals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (commodityValuationDatesSequence != null ? commodityValuationDatesSequence.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityValuationDatesBuilder {" +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"commodityValuationDatesSequence=" + this.commodityValuationDatesSequence + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
