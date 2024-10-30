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
import fpml.confirmation.Commodity;
import fpml.confirmation.Commodity.CommodityBuilder;
import fpml.confirmation.Commodity.CommodityBuilderImpl;
import fpml.confirmation.Commodity.CommodityImpl;
import fpml.confirmation.CommodityProductModel;
import fpml.confirmation.IdentifiedAsset;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilder;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilderImpl;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetImpl;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.meta.CommodityMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies the underlying asset when it is a listed commodity. A type describing a commodity underlying asset.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Commodity", builder=Commodity.CommodityBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Commodity extends IdentifiedAsset {

	CommodityMeta metaData = new CommodityMeta();

	/*********************** Getter Methods  ***********************/
	CommodityProductModel getCommodityProductModel();

	/*********************** Build Methods  ***********************/
	Commodity build();
	
	Commodity.CommodityBuilder toBuilder();
	
	static Commodity.CommodityBuilder builder() {
		return new Commodity.CommodityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Commodity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Commodity> getType() {
		return Commodity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("commodityProductModel"), processor, CommodityProductModel.class, getCommodityProductModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBuilder extends Commodity, IdentifiedAsset.IdentifiedAssetBuilder {
		CommodityProductModel.CommodityProductModelBuilder getOrCreateCommodityProductModel();
		CommodityProductModel.CommodityProductModelBuilder getCommodityProductModel();
		Commodity.CommodityBuilder setId(String id);
		Commodity.CommodityBuilder addInstrumentId(InstrumentId instrumentId0);
		Commodity.CommodityBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Commodity.CommodityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Commodity.CommodityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Commodity.CommodityBuilder setDescription(String description);
		Commodity.CommodityBuilder setCommodityProductModel(CommodityProductModel commodityProductModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("commodityProductModel"), processor, CommodityProductModel.CommodityProductModelBuilder.class, getCommodityProductModel());
		}
		

		Commodity.CommodityBuilder prune();
	}

	/*********************** Immutable Implementation of Commodity  ***********************/
	class CommodityImpl extends IdentifiedAsset.IdentifiedAssetImpl implements Commodity {
		private final CommodityProductModel commodityProductModel;
		
		protected CommodityImpl(Commodity.CommodityBuilder builder) {
			super(builder);
			this.commodityProductModel = ofNullable(builder.getCommodityProductModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityProductModel")
		public CommodityProductModel getCommodityProductModel() {
			return commodityProductModel;
		}
		
		@Override
		public Commodity build() {
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder toBuilder() {
			Commodity.CommodityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Commodity.CommodityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityProductModel()).ifPresent(builder::setCommodityProductModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Commodity _that = getType().cast(o);
		
			if (!Objects.equals(commodityProductModel, _that.getCommodityProductModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityProductModel != null ? commodityProductModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Commodity {" +
				"commodityProductModel=" + this.commodityProductModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Commodity  ***********************/
	class CommodityBuilderImpl extends IdentifiedAsset.IdentifiedAssetBuilderImpl  implements Commodity.CommodityBuilder {
	
		protected CommodityProductModel.CommodityProductModelBuilder commodityProductModel;
	
		public CommodityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityProductModel")
		public CommodityProductModel.CommodityProductModelBuilder getCommodityProductModel() {
			return commodityProductModel;
		}
		
		@Override
		public CommodityProductModel.CommodityProductModelBuilder getOrCreateCommodityProductModel() {
			CommodityProductModel.CommodityProductModelBuilder result;
			if (commodityProductModel!=null) {
				result = commodityProductModel;
			}
			else {
				result = commodityProductModel = CommodityProductModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public Commodity.CommodityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public Commodity.CommodityBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Commodity.CommodityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Commodity.CommodityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		public Commodity.CommodityBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("commodityProductModel")
		public Commodity.CommodityBuilder setCommodityProductModel(CommodityProductModel commodityProductModel) {
			this.commodityProductModel = commodityProductModel==null?null:commodityProductModel.toBuilder();
			return this;
		}
		
		@Override
		public Commodity build() {
			return new Commodity.CommodityImpl(this);
		}
		
		@Override
		public Commodity.CommodityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commodity.CommodityBuilder prune() {
			super.prune();
			if (commodityProductModel!=null && !commodityProductModel.prune().hasData()) commodityProductModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityProductModel()!=null && getCommodityProductModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commodity.CommodityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Commodity.CommodityBuilder o = (Commodity.CommodityBuilder) other;
			
			merger.mergeRosetta(getCommodityProductModel(), o.getCommodityProductModel(), this::setCommodityProductModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Commodity _that = getType().cast(o);
		
			if (!Objects.equals(commodityProductModel, _that.getCommodityProductModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityProductModel != null ? commodityProductModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBuilder {" +
				"commodityProductModel=" + this.commodityProductModel +
			'}' + " " + super.toString();
		}
	}
}
