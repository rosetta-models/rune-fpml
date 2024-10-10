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
import fpml.confirmation.GenericDimension;
import fpml.confirmation.PricingStructureIndexModel;
import fpml.confirmation.PricingStructureIndexModel.PricingStructureIndexModelBuilder;
import fpml.confirmation.PricingStructureIndexModel.PricingStructureIndexModelBuilderImpl;
import fpml.confirmation.PricingStructureIndexModel.PricingStructureIndexModelImpl;
import fpml.confirmation.TimeDimension;
import fpml.confirmation.meta.PricingStructureIndexModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The index (an ordinate) of a pricing structure. The index expresses how far along a particular dimension (e.g. time, strike, etc.) a point is located.
 * @version ${project.version}
 */
@RosettaDataType(value="PricingStructureIndexModel", builder=PricingStructureIndexModel.PricingStructureIndexModelBuilderImpl.class, version="${project.version}")
public interface PricingStructureIndexModel extends RosettaModelObject {

	PricingStructureIndexModelMeta metaData = new PricingStructureIndexModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A time dimension that represents the term of a financial instrument, e.g. of a zero-coupon bond on a curve, or of an underlying caplet or swap for an option.
	 */
	TimeDimension getTerm();
	/**
	 * A time dimension that represents the time to expiration of an option.
	 */
	TimeDimension getExpiration();
	/**
	 * A numerical dimension that represents the strike rate or price of an option.
	 */
	BigDecimal getStrike();
	GenericDimension getGeneric();

	/*********************** Build Methods  ***********************/
	PricingStructureIndexModel build();
	
	PricingStructureIndexModel.PricingStructureIndexModelBuilder toBuilder();
	
	static PricingStructureIndexModel.PricingStructureIndexModelBuilder builder() {
		return new PricingStructureIndexModel.PricingStructureIndexModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructureIndexModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingStructureIndexModel> getType() {
		return PricingStructureIndexModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("term"), processor, TimeDimension.class, getTerm());
		processRosetta(path.newSubPath("expiration"), processor, TimeDimension.class, getExpiration());
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		processRosetta(path.newSubPath("generic"), processor, GenericDimension.class, getGeneric());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructureIndexModelBuilder extends PricingStructureIndexModel, RosettaModelObjectBuilder {
		TimeDimension.TimeDimensionBuilder getOrCreateTerm();
		TimeDimension.TimeDimensionBuilder getTerm();
		TimeDimension.TimeDimensionBuilder getOrCreateExpiration();
		TimeDimension.TimeDimensionBuilder getExpiration();
		GenericDimension.GenericDimensionBuilder getOrCreateGeneric();
		GenericDimension.GenericDimensionBuilder getGeneric();
		PricingStructureIndexModel.PricingStructureIndexModelBuilder setTerm(TimeDimension term);
		PricingStructureIndexModel.PricingStructureIndexModelBuilder setExpiration(TimeDimension expiration);
		PricingStructureIndexModel.PricingStructureIndexModelBuilder setStrike(BigDecimal strike);
		PricingStructureIndexModel.PricingStructureIndexModelBuilder setGeneric(GenericDimension generic);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("term"), processor, TimeDimension.TimeDimensionBuilder.class, getTerm());
			processRosetta(path.newSubPath("expiration"), processor, TimeDimension.TimeDimensionBuilder.class, getExpiration());
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
			processRosetta(path.newSubPath("generic"), processor, GenericDimension.GenericDimensionBuilder.class, getGeneric());
		}
		

		PricingStructureIndexModel.PricingStructureIndexModelBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructureIndexModel  ***********************/
	class PricingStructureIndexModelImpl implements PricingStructureIndexModel {
		private final TimeDimension term;
		private final TimeDimension expiration;
		private final BigDecimal strike;
		private final GenericDimension generic;
		
		protected PricingStructureIndexModelImpl(PricingStructureIndexModel.PricingStructureIndexModelBuilder builder) {
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.expiration = ofNullable(builder.getExpiration()).map(f->f.build()).orElse(null);
			this.strike = builder.getStrike();
			this.generic = ofNullable(builder.getGeneric()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("term")
		public TimeDimension getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("expiration")
		public TimeDimension getExpiration() {
			return expiration;
		}
		
		@Override
		@RosettaAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("generic")
		public GenericDimension getGeneric() {
			return generic;
		}
		
		@Override
		public PricingStructureIndexModel build() {
			return this;
		}
		
		@Override
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder toBuilder() {
			PricingStructureIndexModel.PricingStructureIndexModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructureIndexModel.PricingStructureIndexModelBuilder builder) {
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getExpiration()).ifPresent(builder::setExpiration);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getGeneric()).ifPresent(builder::setGeneric);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructureIndexModel _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(expiration, _that.getExpiration())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(generic, _that.getGeneric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (expiration != null ? expiration.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (generic != null ? generic.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructureIndexModel {" +
				"term=" + this.term + ", " +
				"expiration=" + this.expiration + ", " +
				"strike=" + this.strike + ", " +
				"generic=" + this.generic +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingStructureIndexModel  ***********************/
	class PricingStructureIndexModelBuilderImpl implements PricingStructureIndexModel.PricingStructureIndexModelBuilder {
	
		protected TimeDimension.TimeDimensionBuilder term;
		protected TimeDimension.TimeDimensionBuilder expiration;
		protected BigDecimal strike;
		protected GenericDimension.GenericDimensionBuilder generic;
	
		public PricingStructureIndexModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("term")
		public TimeDimension.TimeDimensionBuilder getTerm() {
			return term;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder getOrCreateTerm() {
			TimeDimension.TimeDimensionBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = TimeDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expiration")
		public TimeDimension.TimeDimensionBuilder getExpiration() {
			return expiration;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder getOrCreateExpiration() {
			TimeDimension.TimeDimensionBuilder result;
			if (expiration!=null) {
				result = expiration;
			}
			else {
				result = expiration = TimeDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("generic")
		public GenericDimension.GenericDimensionBuilder getGeneric() {
			return generic;
		}
		
		@Override
		public GenericDimension.GenericDimensionBuilder getOrCreateGeneric() {
			GenericDimension.GenericDimensionBuilder result;
			if (generic!=null) {
				result = generic;
			}
			else {
				result = generic = GenericDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("term")
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder setTerm(TimeDimension term) {
			this.term = term==null?null:term.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expiration")
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder setExpiration(TimeDimension expiration) {
			this.expiration = expiration==null?null:expiration.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strike")
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder setStrike(BigDecimal strike) {
			this.strike = strike==null?null:strike;
			return this;
		}
		@Override
		@RosettaAttribute("generic")
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder setGeneric(GenericDimension generic) {
			this.generic = generic==null?null:generic.toBuilder();
			return this;
		}
		
		@Override
		public PricingStructureIndexModel build() {
			return new PricingStructureIndexModel.PricingStructureIndexModelImpl(this);
		}
		
		@Override
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder prune() {
			if (term!=null && !term.prune().hasData()) term = null;
			if (expiration!=null && !expiration.prune().hasData()) expiration = null;
			if (generic!=null && !generic.prune().hasData()) generic = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getExpiration()!=null && getExpiration().hasData()) return true;
			if (getStrike()!=null) return true;
			if (getGeneric()!=null && getGeneric().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingStructureIndexModel.PricingStructureIndexModelBuilder o = (PricingStructureIndexModel.PricingStructureIndexModelBuilder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getExpiration(), o.getExpiration(), this::setExpiration);
			merger.mergeRosetta(getGeneric(), o.getGeneric(), this::setGeneric);
			
			merger.mergeBasic(getStrike(), o.getStrike(), this::setStrike);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructureIndexModel _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(expiration, _that.getExpiration())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(generic, _that.getGeneric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (expiration != null ? expiration.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (generic != null ? generic.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructureIndexModelBuilder {" +
				"term=" + this.term + ", " +
				"expiration=" + this.expiration + ", " +
				"strike=" + this.strike + ", " +
				"generic=" + this.generic +
			'}';
		}
	}
}
