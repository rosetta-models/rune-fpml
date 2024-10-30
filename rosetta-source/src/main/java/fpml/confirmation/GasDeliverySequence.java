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
import fpml.confirmation.CommodityHub;
import fpml.confirmation.GasDeliverySequence;
import fpml.confirmation.GasDeliverySequence.GasDeliverySequenceBuilder;
import fpml.confirmation.GasDeliverySequence.GasDeliverySequenceBuilderImpl;
import fpml.confirmation.GasDeliverySequence.GasDeliverySequenceImpl;
import fpml.confirmation.meta.GasDeliverySequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GasDeliverySequence", builder=GasDeliverySequence.GasDeliverySequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GasDeliverySequence extends RosettaModelObject {

	GasDeliverySequenceMeta metaData = new GasDeliverySequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The hub code of the gas buyer.
	 */
	CommodityHub getBuyerHub();
	/**
	 * The hub code of the has seller.
	 */
	CommodityHub getSellerHub();

	/*********************** Build Methods  ***********************/
	GasDeliverySequence build();
	
	GasDeliverySequence.GasDeliverySequenceBuilder toBuilder();
	
	static GasDeliverySequence.GasDeliverySequenceBuilder builder() {
		return new GasDeliverySequence.GasDeliverySequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasDeliverySequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasDeliverySequence> getType() {
		return GasDeliverySequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerHub"), processor, CommodityHub.class, getBuyerHub());
		processRosetta(path.newSubPath("sellerHub"), processor, CommodityHub.class, getSellerHub());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasDeliverySequenceBuilder extends GasDeliverySequence, RosettaModelObjectBuilder {
		CommodityHub.CommodityHubBuilder getOrCreateBuyerHub();
		CommodityHub.CommodityHubBuilder getBuyerHub();
		CommodityHub.CommodityHubBuilder getOrCreateSellerHub();
		CommodityHub.CommodityHubBuilder getSellerHub();
		GasDeliverySequence.GasDeliverySequenceBuilder setBuyerHub(CommodityHub buyerHub);
		GasDeliverySequence.GasDeliverySequenceBuilder setSellerHub(CommodityHub sellerHub);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerHub"), processor, CommodityHub.CommodityHubBuilder.class, getBuyerHub());
			processRosetta(path.newSubPath("sellerHub"), processor, CommodityHub.CommodityHubBuilder.class, getSellerHub());
		}
		

		GasDeliverySequence.GasDeliverySequenceBuilder prune();
	}

	/*********************** Immutable Implementation of GasDeliverySequence  ***********************/
	class GasDeliverySequenceImpl implements GasDeliverySequence {
		private final CommodityHub buyerHub;
		private final CommodityHub sellerHub;
		
		protected GasDeliverySequenceImpl(GasDeliverySequence.GasDeliverySequenceBuilder builder) {
			this.buyerHub = ofNullable(builder.getBuyerHub()).map(f->f.build()).orElse(null);
			this.sellerHub = ofNullable(builder.getSellerHub()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerHub")
		public CommodityHub getBuyerHub() {
			return buyerHub;
		}
		
		@Override
		@RosettaAttribute("sellerHub")
		public CommodityHub getSellerHub() {
			return sellerHub;
		}
		
		@Override
		public GasDeliverySequence build() {
			return this;
		}
		
		@Override
		public GasDeliverySequence.GasDeliverySequenceBuilder toBuilder() {
			GasDeliverySequence.GasDeliverySequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasDeliverySequence.GasDeliverySequenceBuilder builder) {
			ofNullable(getBuyerHub()).ifPresent(builder::setBuyerHub);
			ofNullable(getSellerHub()).ifPresent(builder::setSellerHub);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDeliverySequence _that = getType().cast(o);
		
			if (!Objects.equals(buyerHub, _that.getBuyerHub())) return false;
			if (!Objects.equals(sellerHub, _that.getSellerHub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerHub != null ? buyerHub.hashCode() : 0);
			_result = 31 * _result + (sellerHub != null ? sellerHub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliverySequence {" +
				"buyerHub=" + this.buyerHub + ", " +
				"sellerHub=" + this.sellerHub +
			'}';
		}
	}

	/*********************** Builder Implementation of GasDeliverySequence  ***********************/
	class GasDeliverySequenceBuilderImpl implements GasDeliverySequence.GasDeliverySequenceBuilder {
	
		protected CommodityHub.CommodityHubBuilder buyerHub;
		protected CommodityHub.CommodityHubBuilder sellerHub;
	
		public GasDeliverySequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerHub")
		public CommodityHub.CommodityHubBuilder getBuyerHub() {
			return buyerHub;
		}
		
		@Override
		public CommodityHub.CommodityHubBuilder getOrCreateBuyerHub() {
			CommodityHub.CommodityHubBuilder result;
			if (buyerHub!=null) {
				result = buyerHub;
			}
			else {
				result = buyerHub = CommodityHub.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerHub")
		public CommodityHub.CommodityHubBuilder getSellerHub() {
			return sellerHub;
		}
		
		@Override
		public CommodityHub.CommodityHubBuilder getOrCreateSellerHub() {
			CommodityHub.CommodityHubBuilder result;
			if (sellerHub!=null) {
				result = sellerHub;
			}
			else {
				result = sellerHub = CommodityHub.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerHub")
		public GasDeliverySequence.GasDeliverySequenceBuilder setBuyerHub(CommodityHub buyerHub) {
			this.buyerHub = buyerHub==null?null:buyerHub.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sellerHub")
		public GasDeliverySequence.GasDeliverySequenceBuilder setSellerHub(CommodityHub sellerHub) {
			this.sellerHub = sellerHub==null?null:sellerHub.toBuilder();
			return this;
		}
		
		@Override
		public GasDeliverySequence build() {
			return new GasDeliverySequence.GasDeliverySequenceImpl(this);
		}
		
		@Override
		public GasDeliverySequence.GasDeliverySequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliverySequence.GasDeliverySequenceBuilder prune() {
			if (buyerHub!=null && !buyerHub.prune().hasData()) buyerHub = null;
			if (sellerHub!=null && !sellerHub.prune().hasData()) sellerHub = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyerHub()!=null && getBuyerHub().hasData()) return true;
			if (getSellerHub()!=null && getSellerHub().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliverySequence.GasDeliverySequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasDeliverySequence.GasDeliverySequenceBuilder o = (GasDeliverySequence.GasDeliverySequenceBuilder) other;
			
			merger.mergeRosetta(getBuyerHub(), o.getBuyerHub(), this::setBuyerHub);
			merger.mergeRosetta(getSellerHub(), o.getSellerHub(), this::setSellerHub);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDeliverySequence _that = getType().cast(o);
		
			if (!Objects.equals(buyerHub, _that.getBuyerHub())) return false;
			if (!Objects.equals(sellerHub, _that.getSellerHub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerHub != null ? buyerHub.hashCode() : 0);
			_result = 31 * _result + (sellerHub != null ? sellerHub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliverySequenceBuilder {" +
				"buyerHub=" + this.buyerHub + ", " +
				"sellerHub=" + this.sellerHub +
			'}';
		}
	}
}
