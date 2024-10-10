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
import fpml.confirmation.Option;
import fpml.confirmation.Option.OptionBuilder;
import fpml.confirmation.Option.OptionBuilderImpl;
import fpml.confirmation.Option.OptionImpl;
import fpml.confirmation.OptionBase;
import fpml.confirmation.OptionBase.OptionBaseBuilder;
import fpml.confirmation.OptionBase.OptionBaseBuilderImpl;
import fpml.confirmation.OptionBase.OptionBaseImpl;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.OptionBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the common features of options.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionBase", builder=OptionBase.OptionBaseBuilderImpl.class, version="${project.version}")
public interface OptionBase extends Option {

	OptionBaseMeta metaData = new OptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of option transaction. From a usage standpoint, put/call is the default option type, while payer/receiver indicator is used for options index credit default swaps, consistently with the industry practice. Straddle is used for the case of straddle strategy, that combine a call and a put with the same strike.
	 */
	OptionTypeEnum getOptionType();

	/*********************** Build Methods  ***********************/
	OptionBase build();
	
	OptionBase.OptionBaseBuilder toBuilder();
	
	static OptionBase.OptionBaseBuilder builder() {
		return new OptionBase.OptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionBase> getType() {
		return OptionBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionBaseBuilder extends OptionBase, Option.OptionBuilder {
		OptionBase.OptionBaseBuilder setProductModel(ProductModel productModel);
		OptionBase.OptionBaseBuilder setId(String id);
		OptionBase.OptionBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		OptionBase.OptionBaseBuilder setOptionType(OptionTypeEnum optionType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
		}
		

		OptionBase.OptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of OptionBase  ***********************/
	class OptionBaseImpl extends Option.OptionImpl implements OptionBase {
		private final OptionTypeEnum optionType;
		
		protected OptionBaseImpl(OptionBase.OptionBaseBuilder builder) {
			super(builder);
			this.optionType = builder.getOptionType();
		}
		
		@Override
		@RosettaAttribute("optionType")
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		public OptionBase build() {
			return this;
		}
		
		@Override
		public OptionBase.OptionBaseBuilder toBuilder() {
			OptionBase.OptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionBase.OptionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionBase _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBase {" +
				"optionType=" + this.optionType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionBase  ***********************/
	class OptionBaseBuilderImpl extends Option.OptionBuilderImpl  implements OptionBase.OptionBaseBuilder {
	
		protected OptionTypeEnum optionType;
	
		public OptionBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionType")
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public OptionBase.OptionBaseBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public OptionBase.OptionBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public OptionBase.OptionBaseBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public OptionBase.OptionBaseBuilder setOptionType(OptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		
		@Override
		public OptionBase build() {
			return new OptionBase.OptionBaseImpl(this);
		}
		
		@Override
		public OptionBase.OptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBase.OptionBaseBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOptionType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBase.OptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionBase.OptionBaseBuilder o = (OptionBase.OptionBaseBuilder) other;
			
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionBase _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBaseBuilder {" +
				"optionType=" + this.optionType +
			'}' + " " + super.toString();
		}
	}
}
