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
import fpml.confirmation.NotionalReference;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.UnitQuantity;
import fpml.confirmation.UnitQuantity.UnitQuantityBuilder;
import fpml.confirmation.UnitQuantity.UnitQuantityBuilderImpl;
import fpml.confirmation.UnitQuantity.UnitQuantityImpl;
import fpml.confirmation.UnitQuantityRef;
import fpml.confirmation.UnitQuantityRef.UnitQuantityRefBuilder;
import fpml.confirmation.UnitQuantityRef.UnitQuantityRefBuilderImpl;
import fpml.confirmation.UnitQuantityRef.UnitQuantityRefImpl;
import fpml.confirmation.meta.UnitQuantityRefMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a quantity and unit with a reference.
 * @version ${project.version}
 */
@RosettaDataType(value="UnitQuantityRef", builder=UnitQuantityRef.UnitQuantityRefBuilderImpl.class, version="${project.version}")
public interface UnitQuantityRef extends UnitQuantity {

	UnitQuantityRefMeta metaData = new UnitQuantityRefMeta();

	/*********************** Getter Methods  ***********************/
	NotionalReference getQuantityReference();

	/*********************** Build Methods  ***********************/
	UnitQuantityRef build();
	
	UnitQuantityRef.UnitQuantityRefBuilder toBuilder();
	
	static UnitQuantityRef.UnitQuantityRefBuilder builder() {
		return new UnitQuantityRef.UnitQuantityRefBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnitQuantityRef> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnitQuantityRef> getType() {
		return UnitQuantityRef.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.class, getQuantityUnit());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quantityReference"), processor, NotionalReference.class, getQuantityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnitQuantityRefBuilder extends UnitQuantityRef, UnitQuantity.UnitQuantityBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateQuantityReference();
		NotionalReference.NotionalReferenceBuilder getQuantityReference();
		UnitQuantityRef.UnitQuantityRefBuilder setQuantityUnit(QuantityUnit quantityUnit);
		UnitQuantityRef.UnitQuantityRefBuilder setQuantity(BigDecimal quantity);
		UnitQuantityRef.UnitQuantityRefBuilder setId(String id);
		UnitQuantityRef.UnitQuantityRefBuilder setQuantityReference(NotionalReference quantityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quantityReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getQuantityReference());
		}
		

		UnitQuantityRef.UnitQuantityRefBuilder prune();
	}

	/*********************** Immutable Implementation of UnitQuantityRef  ***********************/
	class UnitQuantityRefImpl extends UnitQuantity.UnitQuantityImpl implements UnitQuantityRef {
		private final NotionalReference quantityReference;
		
		protected UnitQuantityRefImpl(UnitQuantityRef.UnitQuantityRefBuilder builder) {
			super(builder);
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		public NotionalReference getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public UnitQuantityRef build() {
			return this;
		}
		
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder toBuilder() {
			UnitQuantityRef.UnitQuantityRefBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnitQuantityRef.UnitQuantityRefBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnitQuantityRef _that = getType().cast(o);
		
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitQuantityRef {" +
				"quantityReference=" + this.quantityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UnitQuantityRef  ***********************/
	class UnitQuantityRefBuilderImpl extends UnitQuantity.UnitQuantityBuilderImpl  implements UnitQuantityRef.UnitQuantityRefBuilder {
	
		protected NotionalReference.NotionalReferenceBuilder quantityReference;
	
		public UnitQuantityRefBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quantityReference")
		public NotionalReference.NotionalReferenceBuilder getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateQuantityReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (quantityReference!=null) {
				result = quantityReference;
			}
			else {
				result = quantityReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		public UnitQuantityRef.UnitQuantityRefBuilder setQuantityUnit(QuantityUnit quantityUnit) {
			this.quantityUnit = quantityUnit==null?null:quantityUnit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantity")
		public UnitQuantityRef.UnitQuantityRefBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public UnitQuantityRef.UnitQuantityRefBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("quantityReference")
		public UnitQuantityRef.UnitQuantityRefBuilder setQuantityReference(NotionalReference quantityReference) {
			this.quantityReference = quantityReference==null?null:quantityReference.toBuilder();
			return this;
		}
		
		@Override
		public UnitQuantityRef build() {
			return new UnitQuantityRef.UnitQuantityRefImpl(this);
		}
		
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder prune() {
			super.prune();
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			UnitQuantityRef.UnitQuantityRefBuilder o = (UnitQuantityRef.UnitQuantityRefBuilder) other;
			
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnitQuantityRef _that = getType().cast(o);
		
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitQuantityRefBuilder {" +
				"quantityReference=" + this.quantityReference +
			'}' + " " + super.toString();
		}
	}
}
