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
import fpml.confirmation.ClassifiablePayment;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.NettedSwapBase;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseBuilder;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseBuilderImpl;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseImpl;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.NettedSwapBaseMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base class for all swap types which have a single netted leg, such as Variance Swaps, and Correlation Swaps.
 * @version ${project.version}
 */
@RosettaDataType(value="NettedSwapBase", builder=NettedSwapBase.NettedSwapBaseBuilderImpl.class, version="${project.version}")
public interface NettedSwapBase extends Product {

	NettedSwapBaseMeta metaData = new NettedSwapBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies additional payment(s) between the principal parties to the netted swap.
	 */
	List<? extends ClassifiablePayment> getAdditionalPayment();
	/**
	 * Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	NettedSwapBase build();
	
	NettedSwapBase.NettedSwapBaseBuilder toBuilder();
	
	static NettedSwapBase.NettedSwapBaseBuilder builder() {
		return new NettedSwapBase.NettedSwapBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NettedSwapBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NettedSwapBase> getType() {
		return NettedSwapBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NettedSwapBaseBuilder extends NettedSwapBase, Product.ProductBuilder {
		ClassifiablePayment.ClassifiablePaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends ClassifiablePayment.ClassifiablePaymentBuilder> getAdditionalPayment();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		NettedSwapBase.NettedSwapBaseBuilder setProductModel(ProductModel productModel);
		NettedSwapBase.NettedSwapBaseBuilder setId(String id);
		NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(ClassifiablePayment additionalPayment0);
		NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(ClassifiablePayment additionalPayment1, int _idx);
		NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment2);
		NettedSwapBase.NettedSwapBaseBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment3);
		NettedSwapBase.NettedSwapBaseBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.ClassifiablePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
		}
		

		NettedSwapBase.NettedSwapBaseBuilder prune();
	}

	/*********************** Immutable Implementation of NettedSwapBase  ***********************/
	class NettedSwapBaseImpl extends Product.ProductImpl implements NettedSwapBase {
		private final List<? extends ClassifiablePayment> additionalPayment;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected NettedSwapBaseImpl(NettedSwapBase.NettedSwapBaseBuilder builder) {
			super(builder);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends ClassifiablePayment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public NettedSwapBase build() {
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder toBuilder() {
			NettedSwapBase.NettedSwapBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NettedSwapBase.NettedSwapBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NettedSwapBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NettedSwapBase {" +
				"additionalPayment=" + this.additionalPayment + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NettedSwapBase  ***********************/
	class NettedSwapBaseBuilderImpl extends Product.ProductBuilderImpl  implements NettedSwapBase.NettedSwapBaseBuilder {
	
		protected List<ClassifiablePayment.ClassifiablePaymentBuilder> additionalPayment = new ArrayList<>();
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
	
		public NettedSwapBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends ClassifiablePayment.ClassifiablePaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		public ClassifiablePayment.ClassifiablePaymentBuilder getOrCreateAdditionalPayment(int _index) {
		
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			ClassifiablePayment.ClassifiablePaymentBuilder result;
			return getIndex(additionalPayment, _index, () -> {
						ClassifiablePayment.ClassifiablePaymentBuilder newAdditionalPayment = ClassifiablePayment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder result;
			if (extraordinaryEvents!=null) {
				result = extraordinaryEvents;
			}
			else {
				result = extraordinaryEvents = ExtraordinaryEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public NettedSwapBase.NettedSwapBaseBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public NettedSwapBase.NettedSwapBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(ClassifiablePayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(ClassifiablePayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (ClassifiablePayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public NettedSwapBase.NettedSwapBaseBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
			if (additionalPayments == null)  {
				this.additionalPayment = new ArrayList<>();
			}
			else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public NettedSwapBase.NettedSwapBaseBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public NettedSwapBase build() {
			return new NettedSwapBase.NettedSwapBaseImpl(this);
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder prune() {
			super.prune();
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<ClassifiablePayment.ClassifiablePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NettedSwapBase.NettedSwapBaseBuilder o = (NettedSwapBase.NettedSwapBaseBuilder) other;
			
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NettedSwapBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NettedSwapBaseBuilder {" +
				"additionalPayment=" + this.additionalPayment + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}
