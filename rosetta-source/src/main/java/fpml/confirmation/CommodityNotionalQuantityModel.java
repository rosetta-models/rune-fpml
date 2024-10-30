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
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder;
import fpml.confirmation.CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilderImpl;
import fpml.confirmation.CommodityNotionalQuantityModel.CommodityNotionalQuantityModelImpl;
import fpml.confirmation.CommodityNotionalQuantityModelSequence;
import fpml.confirmation.QuantityReference;
import fpml.confirmation.meta.CommodityNotionalQuantityModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the Notional Quantity. A flat notional for the term of the contract may be specified, or else the Notional Quantity per Calculation Period. In the latter case, there must be a notional quantity step specified for each Calculation Period, regardless of whether the Notional Quantity changes or remains the same between periods.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityNotionalQuantityModel", builder=CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityNotionalQuantityModel extends RosettaModelObject {

	CommodityNotionalQuantityModelMeta metaData = new CommodityNotionalQuantityModelMeta();

	/*********************** Getter Methods  ***********************/
	CommodityNotionalQuantityModelSequence getCommodityNotionalQuantityModelSequence();
	/**
	 * A pointer style reference to a quantity defined on another leg.
	 */
	QuantityReference getQuantityReference();

	/*********************** Build Methods  ***********************/
	CommodityNotionalQuantityModel build();
	
	CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder toBuilder();
	
	static CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder builder() {
		return new CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalQuantityModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityNotionalQuantityModel> getType() {
		return CommodityNotionalQuantityModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityNotionalQuantityModelSequence"), processor, CommodityNotionalQuantityModelSequence.class, getCommodityNotionalQuantityModelSequence());
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalQuantityModelBuilder extends CommodityNotionalQuantityModel, RosettaModelObjectBuilder {
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder getOrCreateCommodityNotionalQuantityModelSequence();
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder getCommodityNotionalQuantityModelSequence();
		QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference();
		QuantityReference.QuantityReferenceBuilder getQuantityReference();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder setCommodityNotionalQuantityModelSequence(CommodityNotionalQuantityModelSequence commodityNotionalQuantityModelSequence);
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder setQuantityReference(QuantityReference quantityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityNotionalQuantityModelSequence"), processor, CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder.class, getCommodityNotionalQuantityModelSequence());
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
		}
		

		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalQuantityModel  ***********************/
	class CommodityNotionalQuantityModelImpl implements CommodityNotionalQuantityModel {
		private final CommodityNotionalQuantityModelSequence commodityNotionalQuantityModelSequence;
		private final QuantityReference quantityReference;
		
		protected CommodityNotionalQuantityModelImpl(CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder builder) {
			this.commodityNotionalQuantityModelSequence = ofNullable(builder.getCommodityNotionalQuantityModelSequence()).map(f->f.build()).orElse(null);
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModelSequence")
		public CommodityNotionalQuantityModelSequence getCommodityNotionalQuantityModelSequence() {
			return commodityNotionalQuantityModelSequence;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		public QuantityReference getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public CommodityNotionalQuantityModel build() {
			return this;
		}
		
		@Override
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder toBuilder() {
			CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder builder) {
			ofNullable(getCommodityNotionalQuantityModelSequence()).ifPresent(builder::setCommodityNotionalQuantityModelSequence);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantityModel _that = getType().cast(o);
		
			if (!Objects.equals(commodityNotionalQuantityModelSequence, _that.getCommodityNotionalQuantityModelSequence())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityNotionalQuantityModelSequence != null ? commodityNotionalQuantityModelSequence.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantityModel {" +
				"commodityNotionalQuantityModelSequence=" + this.commodityNotionalQuantityModelSequence + ", " +
				"quantityReference=" + this.quantityReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityNotionalQuantityModel  ***********************/
	class CommodityNotionalQuantityModelBuilderImpl implements CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder {
	
		protected CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder commodityNotionalQuantityModelSequence;
		protected QuantityReference.QuantityReferenceBuilder quantityReference;
	
		public CommodityNotionalQuantityModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityNotionalQuantityModelSequence")
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder getCommodityNotionalQuantityModelSequence() {
			return commodityNotionalQuantityModelSequence;
		}
		
		@Override
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder getOrCreateCommodityNotionalQuantityModelSequence() {
			CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder result;
			if (commodityNotionalQuantityModelSequence!=null) {
				result = commodityNotionalQuantityModelSequence;
			}
			else {
				result = commodityNotionalQuantityModelSequence = CommodityNotionalQuantityModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		public QuantityReference.QuantityReferenceBuilder getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference() {
			QuantityReference.QuantityReferenceBuilder result;
			if (quantityReference!=null) {
				result = quantityReference;
			}
			else {
				result = quantityReference = QuantityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModelSequence")
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder setCommodityNotionalQuantityModelSequence(CommodityNotionalQuantityModelSequence commodityNotionalQuantityModelSequence) {
			this.commodityNotionalQuantityModelSequence = commodityNotionalQuantityModelSequence==null?null:commodityNotionalQuantityModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantityReference")
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder setQuantityReference(QuantityReference quantityReference) {
			this.quantityReference = quantityReference==null?null:quantityReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityNotionalQuantityModel build() {
			return new CommodityNotionalQuantityModel.CommodityNotionalQuantityModelImpl(this);
		}
		
		@Override
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder prune() {
			if (commodityNotionalQuantityModelSequence!=null && !commodityNotionalQuantityModelSequence.prune().hasData()) commodityNotionalQuantityModelSequence = null;
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityNotionalQuantityModelSequence()!=null && getCommodityNotionalQuantityModelSequence().hasData()) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder o = (CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder) other;
			
			merger.mergeRosetta(getCommodityNotionalQuantityModelSequence(), o.getCommodityNotionalQuantityModelSequence(), this::setCommodityNotionalQuantityModelSequence);
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantityModel _that = getType().cast(o);
		
			if (!Objects.equals(commodityNotionalQuantityModelSequence, _that.getCommodityNotionalQuantityModelSequence())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityNotionalQuantityModelSequence != null ? commodityNotionalQuantityModelSequence.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantityModelBuilder {" +
				"commodityNotionalQuantityModelSequence=" + this.commodityNotionalQuantityModelSequence + ", " +
				"quantityReference=" + this.quantityReference +
			'}';
		}
	}
}
