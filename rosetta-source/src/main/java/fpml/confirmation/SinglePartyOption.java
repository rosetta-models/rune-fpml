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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.SinglePartyOption;
import fpml.confirmation.SinglePartyOption.SinglePartyOptionBuilder;
import fpml.confirmation.SinglePartyOption.SinglePartyOptionBuilderImpl;
import fpml.confirmation.SinglePartyOption.SinglePartyOptionImpl;
import fpml.confirmation.meta.SinglePartyOptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the buyer and seller of an option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SinglePartyOption", builder=SinglePartyOption.SinglePartyOptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SinglePartyOption extends RosettaModelObject {

	SinglePartyOptionMeta metaData = new SinglePartyOptionMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();

	/*********************** Build Methods  ***********************/
	SinglePartyOption build();
	
	SinglePartyOption.SinglePartyOptionBuilder toBuilder();
	
	static SinglePartyOption.SinglePartyOptionBuilder builder() {
		return new SinglePartyOption.SinglePartyOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SinglePartyOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SinglePartyOption> getType() {
		return SinglePartyOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SinglePartyOptionBuilder extends SinglePartyOption, RosettaModelObjectBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		SinglePartyOption.SinglePartyOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
		}
		

		SinglePartyOption.SinglePartyOptionBuilder prune();
	}

	/*********************** Immutable Implementation of SinglePartyOption  ***********************/
	class SinglePartyOptionImpl implements SinglePartyOption {
		private final BuyerSellerModel buyerSellerModel;
		
		protected SinglePartyOptionImpl(SinglePartyOption.SinglePartyOptionBuilder builder) {
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public SinglePartyOption build() {
			return this;
		}
		
		@Override
		public SinglePartyOption.SinglePartyOptionBuilder toBuilder() {
			SinglePartyOption.SinglePartyOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SinglePartyOption.SinglePartyOptionBuilder builder) {
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SinglePartyOption _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SinglePartyOption {" +
				"buyerSellerModel=" + this.buyerSellerModel +
			'}';
		}
	}

	/*********************** Builder Implementation of SinglePartyOption  ***********************/
	class SinglePartyOptionBuilderImpl implements SinglePartyOption.SinglePartyOptionBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
	
		public SinglePartyOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public SinglePartyOption.SinglePartyOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		
		@Override
		public SinglePartyOption build() {
			return new SinglePartyOption.SinglePartyOptionImpl(this);
		}
		
		@Override
		public SinglePartyOption.SinglePartyOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SinglePartyOption.SinglePartyOptionBuilder prune() {
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SinglePartyOption.SinglePartyOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SinglePartyOption.SinglePartyOptionBuilder o = (SinglePartyOption.SinglePartyOptionBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SinglePartyOption _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SinglePartyOptionBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel +
			'}';
		}
	}
}
