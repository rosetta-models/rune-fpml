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
import fpml.confirmation.PricingCoordinateOrReferenceModel;
import fpml.confirmation.PricingStructurePoint;
import fpml.confirmation.PricingStructurePoint.PricingStructurePointBuilder;
import fpml.confirmation.PricingStructurePoint.PricingStructurePointBuilderImpl;
import fpml.confirmation.PricingStructurePoint.PricingStructurePointImpl;
import fpml.confirmation.QuotationModel;
import fpml.confirmation.UnderlyingAssetOrReferenceModel;
import fpml.confirmation.meta.PricingStructurePointMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A single valued point with a set of coordinates that define an arbitrary number of indentifying indexes (0 or more). Note that the collection of coordinates/coordinate references for a PricingStructurePoint must not define a given dimension (other than &quot;generic&quot;) more than once. This is to avoid ambiguity.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PricingStructurePoint", builder=PricingStructurePoint.PricingStructurePointBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PricingStructurePoint extends RosettaModelObject {

	PricingStructurePointMeta metaData = new PricingStructurePointMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PricingCoordinateOrReferenceModel> getPricingCoordinateOrReferenceModel();
	UnderlyingAssetOrReferenceModel getUnderlyingAssetOrReferenceModel();
	QuotationModel getQuotationModel();
	String getId();

	/*********************** Build Methods  ***********************/
	PricingStructurePoint build();
	
	PricingStructurePoint.PricingStructurePointBuilder toBuilder();
	
	static PricingStructurePoint.PricingStructurePointBuilder builder() {
		return new PricingStructurePoint.PricingStructurePointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructurePoint> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingStructurePoint> getType() {
		return PricingStructurePoint.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pricingCoordinateOrReferenceModel"), processor, PricingCoordinateOrReferenceModel.class, getPricingCoordinateOrReferenceModel());
		processRosetta(path.newSubPath("underlyingAssetOrReferenceModel"), processor, UnderlyingAssetOrReferenceModel.class, getUnderlyingAssetOrReferenceModel());
		processRosetta(path.newSubPath("quotationModel"), processor, QuotationModel.class, getQuotationModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructurePointBuilder extends PricingStructurePoint, RosettaModelObjectBuilder {
		PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder getOrCreatePricingCoordinateOrReferenceModel(int _index);
		List<? extends PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder> getPricingCoordinateOrReferenceModel();
		UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder getOrCreateUnderlyingAssetOrReferenceModel();
		UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder getUnderlyingAssetOrReferenceModel();
		QuotationModel.QuotationModelBuilder getOrCreateQuotationModel();
		QuotationModel.QuotationModelBuilder getQuotationModel();
		PricingStructurePoint.PricingStructurePointBuilder addPricingCoordinateOrReferenceModel(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel0);
		PricingStructurePoint.PricingStructurePointBuilder addPricingCoordinateOrReferenceModel(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel1, int _idx);
		PricingStructurePoint.PricingStructurePointBuilder addPricingCoordinateOrReferenceModel(List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModel2);
		PricingStructurePoint.PricingStructurePointBuilder setPricingCoordinateOrReferenceModel(List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModel3);
		PricingStructurePoint.PricingStructurePointBuilder setUnderlyingAssetOrReferenceModel(UnderlyingAssetOrReferenceModel underlyingAssetOrReferenceModel);
		PricingStructurePoint.PricingStructurePointBuilder setQuotationModel(QuotationModel quotationModel);
		PricingStructurePoint.PricingStructurePointBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pricingCoordinateOrReferenceModel"), processor, PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder.class, getPricingCoordinateOrReferenceModel());
			processRosetta(path.newSubPath("underlyingAssetOrReferenceModel"), processor, UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder.class, getUnderlyingAssetOrReferenceModel());
			processRosetta(path.newSubPath("quotationModel"), processor, QuotationModel.QuotationModelBuilder.class, getQuotationModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PricingStructurePoint.PricingStructurePointBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructurePoint  ***********************/
	class PricingStructurePointImpl implements PricingStructurePoint {
		private final List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModel;
		private final UnderlyingAssetOrReferenceModel underlyingAssetOrReferenceModel;
		private final QuotationModel quotationModel;
		private final String id;
		
		protected PricingStructurePointImpl(PricingStructurePoint.PricingStructurePointBuilder builder) {
			this.pricingCoordinateOrReferenceModel = ofNullable(builder.getPricingCoordinateOrReferenceModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.underlyingAssetOrReferenceModel = ofNullable(builder.getUnderlyingAssetOrReferenceModel()).map(f->f.build()).orElse(null);
			this.quotationModel = ofNullable(builder.getQuotationModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("pricingCoordinateOrReferenceModel")
		public List<? extends PricingCoordinateOrReferenceModel> getPricingCoordinateOrReferenceModel() {
			return pricingCoordinateOrReferenceModel;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetOrReferenceModel")
		public UnderlyingAssetOrReferenceModel getUnderlyingAssetOrReferenceModel() {
			return underlyingAssetOrReferenceModel;
		}
		
		@Override
		@RosettaAttribute("quotationModel")
		public QuotationModel getQuotationModel() {
			return quotationModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PricingStructurePoint build() {
			return this;
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder toBuilder() {
			PricingStructurePoint.PricingStructurePointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructurePoint.PricingStructurePointBuilder builder) {
			ofNullable(getPricingCoordinateOrReferenceModel()).ifPresent(builder::setPricingCoordinateOrReferenceModel);
			ofNullable(getUnderlyingAssetOrReferenceModel()).ifPresent(builder::setUnderlyingAssetOrReferenceModel);
			ofNullable(getQuotationModel()).ifPresent(builder::setQuotationModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructurePoint _that = getType().cast(o);
		
			if (!ListEquals.listEquals(pricingCoordinateOrReferenceModel, _that.getPricingCoordinateOrReferenceModel())) return false;
			if (!Objects.equals(underlyingAssetOrReferenceModel, _that.getUnderlyingAssetOrReferenceModel())) return false;
			if (!Objects.equals(quotationModel, _that.getQuotationModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingCoordinateOrReferenceModel != null ? pricingCoordinateOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetOrReferenceModel != null ? underlyingAssetOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (quotationModel != null ? quotationModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructurePoint {" +
				"pricingCoordinateOrReferenceModel=" + this.pricingCoordinateOrReferenceModel + ", " +
				"underlyingAssetOrReferenceModel=" + this.underlyingAssetOrReferenceModel + ", " +
				"quotationModel=" + this.quotationModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingStructurePoint  ***********************/
	class PricingStructurePointBuilderImpl implements PricingStructurePoint.PricingStructurePointBuilder {
	
		protected List<PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder> pricingCoordinateOrReferenceModel = new ArrayList<>();
		protected UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder underlyingAssetOrReferenceModel;
		protected QuotationModel.QuotationModelBuilder quotationModel;
		protected String id;
	
		public PricingStructurePointBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pricingCoordinateOrReferenceModel")
		public List<? extends PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder> getPricingCoordinateOrReferenceModel() {
			return pricingCoordinateOrReferenceModel;
		}
		
		@Override
		public PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder getOrCreatePricingCoordinateOrReferenceModel(int _index) {
		
			if (pricingCoordinateOrReferenceModel==null) {
				this.pricingCoordinateOrReferenceModel = new ArrayList<>();
			}
			PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder result;
			return getIndex(pricingCoordinateOrReferenceModel, _index, () -> {
						PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder newPricingCoordinateOrReferenceModel = PricingCoordinateOrReferenceModel.builder();
						return newPricingCoordinateOrReferenceModel;
					});
		}
		
		@Override
		@RosettaAttribute("underlyingAssetOrReferenceModel")
		public UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder getUnderlyingAssetOrReferenceModel() {
			return underlyingAssetOrReferenceModel;
		}
		
		@Override
		public UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder getOrCreateUnderlyingAssetOrReferenceModel() {
			UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder result;
			if (underlyingAssetOrReferenceModel!=null) {
				result = underlyingAssetOrReferenceModel;
			}
			else {
				result = underlyingAssetOrReferenceModel = UnderlyingAssetOrReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationModel")
		public QuotationModel.QuotationModelBuilder getQuotationModel() {
			return quotationModel;
		}
		
		@Override
		public QuotationModel.QuotationModelBuilder getOrCreateQuotationModel() {
			QuotationModel.QuotationModelBuilder result;
			if (quotationModel!=null) {
				result = quotationModel;
			}
			else {
				result = quotationModel = QuotationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("pricingCoordinateOrReferenceModel")
		public PricingStructurePoint.PricingStructurePointBuilder addPricingCoordinateOrReferenceModel(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel) {
			if (pricingCoordinateOrReferenceModel!=null) this.pricingCoordinateOrReferenceModel.add(pricingCoordinateOrReferenceModel.toBuilder());
			return this;
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder addPricingCoordinateOrReferenceModel(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel, int _idx) {
			getIndex(this.pricingCoordinateOrReferenceModel, _idx, () -> pricingCoordinateOrReferenceModel.toBuilder());
			return this;
		}
		@Override 
		public PricingStructurePoint.PricingStructurePointBuilder addPricingCoordinateOrReferenceModel(List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModels) {
			if (pricingCoordinateOrReferenceModels != null) {
				for (PricingCoordinateOrReferenceModel toAdd : pricingCoordinateOrReferenceModels) {
					this.pricingCoordinateOrReferenceModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PricingStructurePoint.PricingStructurePointBuilder setPricingCoordinateOrReferenceModel(List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModels) {
			if (pricingCoordinateOrReferenceModels == null)  {
				this.pricingCoordinateOrReferenceModel = new ArrayList<>();
			}
			else {
				this.pricingCoordinateOrReferenceModel = pricingCoordinateOrReferenceModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetOrReferenceModel")
		public PricingStructurePoint.PricingStructurePointBuilder setUnderlyingAssetOrReferenceModel(UnderlyingAssetOrReferenceModel underlyingAssetOrReferenceModel) {
			this.underlyingAssetOrReferenceModel = underlyingAssetOrReferenceModel==null?null:underlyingAssetOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotationModel")
		public PricingStructurePoint.PricingStructurePointBuilder setQuotationModel(QuotationModel quotationModel) {
			this.quotationModel = quotationModel==null?null:quotationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PricingStructurePoint.PricingStructurePointBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PricingStructurePoint build() {
			return new PricingStructurePoint.PricingStructurePointImpl(this);
		}
		
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder prune() {
			pricingCoordinateOrReferenceModel = pricingCoordinateOrReferenceModel.stream().filter(b->b!=null).<PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (underlyingAssetOrReferenceModel!=null && !underlyingAssetOrReferenceModel.prune().hasData()) underlyingAssetOrReferenceModel = null;
			if (quotationModel!=null && !quotationModel.prune().hasData()) quotationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPricingCoordinateOrReferenceModel()!=null && getPricingCoordinateOrReferenceModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getUnderlyingAssetOrReferenceModel()!=null && getUnderlyingAssetOrReferenceModel().hasData()) return true;
			if (getQuotationModel()!=null && getQuotationModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructurePoint.PricingStructurePointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingStructurePoint.PricingStructurePointBuilder o = (PricingStructurePoint.PricingStructurePointBuilder) other;
			
			merger.mergeRosetta(getPricingCoordinateOrReferenceModel(), o.getPricingCoordinateOrReferenceModel(), this::getOrCreatePricingCoordinateOrReferenceModel);
			merger.mergeRosetta(getUnderlyingAssetOrReferenceModel(), o.getUnderlyingAssetOrReferenceModel(), this::setUnderlyingAssetOrReferenceModel);
			merger.mergeRosetta(getQuotationModel(), o.getQuotationModel(), this::setQuotationModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructurePoint _that = getType().cast(o);
		
			if (!ListEquals.listEquals(pricingCoordinateOrReferenceModel, _that.getPricingCoordinateOrReferenceModel())) return false;
			if (!Objects.equals(underlyingAssetOrReferenceModel, _that.getUnderlyingAssetOrReferenceModel())) return false;
			if (!Objects.equals(quotationModel, _that.getQuotationModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingCoordinateOrReferenceModel != null ? pricingCoordinateOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetOrReferenceModel != null ? underlyingAssetOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (quotationModel != null ? quotationModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructurePointBuilder {" +
				"pricingCoordinateOrReferenceModel=" + this.pricingCoordinateOrReferenceModel + ", " +
				"underlyingAssetOrReferenceModel=" + this.underlyingAssetOrReferenceModel + ", " +
				"quotationModel=" + this.quotationModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
