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
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VolatilityLeg;
import fpml.confirmation.VolatilitySwapTransactionSupplement;
import fpml.confirmation.VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder;
import fpml.confirmation.VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilderImpl;
import fpml.confirmation.VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementImpl;
import fpml.confirmation.meta.VolatilitySwapTransactionSupplementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="VolatilitySwapTransactionSupplement", builder=VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilderImpl.class, version="${project.version}")
public interface VolatilitySwapTransactionSupplement extends Product {

	VolatilitySwapTransactionSupplementMeta metaData = new VolatilitySwapTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends VolatilityLeg> getVolatilityLeg();
	EquityUnderlyerProvisionsModel getEquityUnderlyerProvisionsModel();

	/*********************** Build Methods  ***********************/
	VolatilitySwapTransactionSupplement build();
	
	VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder toBuilder();
	
	static VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder builder() {
		return new VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilitySwapTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilitySwapTransactionSupplement> getType() {
		return VolatilitySwapTransactionSupplement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("volatilityLeg"), processor, VolatilityLeg.class, getVolatilityLeg());
		processRosetta(path.newSubPath("equityUnderlyerProvisionsModel"), processor, EquityUnderlyerProvisionsModel.class, getEquityUnderlyerProvisionsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilitySwapTransactionSupplementBuilder extends VolatilitySwapTransactionSupplement, Product.ProductBuilder {
		VolatilityLeg.VolatilityLegBuilder getOrCreateVolatilityLeg(int _index);
		List<? extends VolatilityLeg.VolatilityLegBuilder> getVolatilityLeg();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getOrCreateEquityUnderlyerProvisionsModel();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getEquityUnderlyerProvisionsModel();
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setProductModel(ProductModel productModel);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setId(String id);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(VolatilityLeg volatilityLeg0);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(VolatilityLeg volatilityLeg1, int _idx);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(List<? extends VolatilityLeg> volatilityLeg2);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setVolatilityLeg(List<? extends VolatilityLeg> volatilityLeg3);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setEquityUnderlyerProvisionsModel(EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("volatilityLeg"), processor, VolatilityLeg.VolatilityLegBuilder.class, getVolatilityLeg());
			processRosetta(path.newSubPath("equityUnderlyerProvisionsModel"), processor, EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder.class, getEquityUnderlyerProvisionsModel());
		}
		

		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilitySwapTransactionSupplement  ***********************/
	class VolatilitySwapTransactionSupplementImpl extends Product.ProductImpl implements VolatilitySwapTransactionSupplement {
		private final List<? extends VolatilityLeg> volatilityLeg;
		private final EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel;
		
		protected VolatilitySwapTransactionSupplementImpl(VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder builder) {
			super(builder);
			this.volatilityLeg = ofNullable(builder.getVolatilityLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.equityUnderlyerProvisionsModel = ofNullable(builder.getEquityUnderlyerProvisionsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("volatilityLeg")
		public List<? extends VolatilityLeg> getVolatilityLeg() {
			return volatilityLeg;
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public EquityUnderlyerProvisionsModel getEquityUnderlyerProvisionsModel() {
			return equityUnderlyerProvisionsModel;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement build() {
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder toBuilder() {
			VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVolatilityLeg()).ifPresent(builder::setVolatilityLeg);
			ofNullable(getEquityUnderlyerProvisionsModel()).ifPresent(builder::setEquityUnderlyerProvisionsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilitySwapTransactionSupplement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(volatilityLeg, _that.getVolatilityLeg())) return false;
			if (!Objects.equals(equityUnderlyerProvisionsModel, _that.getEquityUnderlyerProvisionsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityLeg != null ? volatilityLeg.hashCode() : 0);
			_result = 31 * _result + (equityUnderlyerProvisionsModel != null ? equityUnderlyerProvisionsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilitySwapTransactionSupplement {" +
				"volatilityLeg=" + this.volatilityLeg + ", " +
				"equityUnderlyerProvisionsModel=" + this.equityUnderlyerProvisionsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilitySwapTransactionSupplement  ***********************/
	class VolatilitySwapTransactionSupplementBuilderImpl extends Product.ProductBuilderImpl  implements VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder {
	
		protected List<VolatilityLeg.VolatilityLegBuilder> volatilityLeg = new ArrayList<>();
		protected EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder equityUnderlyerProvisionsModel;
	
		public VolatilitySwapTransactionSupplementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("volatilityLeg")
		public List<? extends VolatilityLeg.VolatilityLegBuilder> getVolatilityLeg() {
			return volatilityLeg;
		}
		
		public VolatilityLeg.VolatilityLegBuilder getOrCreateVolatilityLeg(int _index) {
		
			if (volatilityLeg==null) {
				this.volatilityLeg = new ArrayList<>();
			}
			VolatilityLeg.VolatilityLegBuilder result;
			return getIndex(volatilityLeg, _index, () -> {
						VolatilityLeg.VolatilityLegBuilder newVolatilityLeg = VolatilityLeg.builder();
						return newVolatilityLeg;
					});
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getEquityUnderlyerProvisionsModel() {
			return equityUnderlyerProvisionsModel;
		}
		
		@Override
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getOrCreateEquityUnderlyerProvisionsModel() {
			EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder result;
			if (equityUnderlyerProvisionsModel!=null) {
				result = equityUnderlyerProvisionsModel;
			}
			else {
				result = equityUnderlyerProvisionsModel = EquityUnderlyerProvisionsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(VolatilityLeg volatilityLeg) {
			if (volatilityLeg!=null) this.volatilityLeg.add(volatilityLeg.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(VolatilityLeg volatilityLeg, int _idx) {
			getIndex(this.volatilityLeg, _idx, () -> volatilityLeg.toBuilder());
			return this;
		}
		@Override 
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(List<? extends VolatilityLeg> volatilityLegs) {
			if (volatilityLegs != null) {
				for (VolatilityLeg toAdd : volatilityLegs) {
					this.volatilityLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("volatilityLeg")
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setVolatilityLeg(List<? extends VolatilityLeg> volatilityLegs) {
			if (volatilityLegs == null)  {
				this.volatilityLeg = new ArrayList<>();
			}
			else {
				this.volatilityLeg = volatilityLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setEquityUnderlyerProvisionsModel(EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel) {
			this.equityUnderlyerProvisionsModel = equityUnderlyerProvisionsModel==null?null:equityUnderlyerProvisionsModel.toBuilder();
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement build() {
			return new VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementImpl(this);
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder prune() {
			super.prune();
			volatilityLeg = volatilityLeg.stream().filter(b->b!=null).<VolatilityLeg.VolatilityLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (equityUnderlyerProvisionsModel!=null && !equityUnderlyerProvisionsModel.prune().hasData()) equityUnderlyerProvisionsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVolatilityLeg()!=null && getVolatilityLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEquityUnderlyerProvisionsModel()!=null && getEquityUnderlyerProvisionsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder o = (VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getVolatilityLeg(), o.getVolatilityLeg(), this::getOrCreateVolatilityLeg);
			merger.mergeRosetta(getEquityUnderlyerProvisionsModel(), o.getEquityUnderlyerProvisionsModel(), this::setEquityUnderlyerProvisionsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilitySwapTransactionSupplement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(volatilityLeg, _that.getVolatilityLeg())) return false;
			if (!Objects.equals(equityUnderlyerProvisionsModel, _that.getEquityUnderlyerProvisionsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityLeg != null ? volatilityLeg.hashCode() : 0);
			_result = 31 * _result + (equityUnderlyerProvisionsModel != null ? equityUnderlyerProvisionsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilitySwapTransactionSupplementBuilder {" +
				"volatilityLeg=" + this.volatilityLeg + ", " +
				"equityUnderlyerProvisionsModel=" + this.equityUnderlyerProvisionsModel +
			'}' + " " + super.toString();
		}
	}
}
