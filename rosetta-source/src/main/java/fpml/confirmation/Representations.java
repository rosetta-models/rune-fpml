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
import fpml.confirmation.Representations;
import fpml.confirmation.Representations.RepresentationsBuilder;
import fpml.confirmation.Representations.RepresentationsBuilderImpl;
import fpml.confirmation.Representations.RepresentationsImpl;
import fpml.confirmation.meta.RepresentationsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining ISDA 2002 Equity Derivative Representations.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Representations", builder=Representations.RepresentationsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Representations extends RosettaModelObject {

	RepresentationsMeta metaData = new RepresentationsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true, then non reliance is applicable.
	 */
	Boolean getNonReliance();
	/**
	 * If true, then agreements regarding hedging are applicable.
	 */
	Boolean getAgreementsRegardingHedging();
	/**
	 * If present and true, then index disclaimer is applicable.
	 */
	Boolean getIndexDisclaimer();
	/**
	 * If true, then additional acknowledgements are applicable.
	 */
	Boolean getAdditionalAcknowledgements();

	/*********************** Build Methods  ***********************/
	Representations build();
	
	Representations.RepresentationsBuilder toBuilder();
	
	static Representations.RepresentationsBuilder builder() {
		return new Representations.RepresentationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Representations> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Representations> getType() {
		return Representations.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nonReliance"), Boolean.class, getNonReliance(), this);
		processor.processBasic(path.newSubPath("agreementsRegardingHedging"), Boolean.class, getAgreementsRegardingHedging(), this);
		processor.processBasic(path.newSubPath("indexDisclaimer"), Boolean.class, getIndexDisclaimer(), this);
		processor.processBasic(path.newSubPath("additionalAcknowledgements"), Boolean.class, getAdditionalAcknowledgements(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepresentationsBuilder extends Representations, RosettaModelObjectBuilder {
		Representations.RepresentationsBuilder setNonReliance(Boolean nonReliance);
		Representations.RepresentationsBuilder setAgreementsRegardingHedging(Boolean agreementsRegardingHedging);
		Representations.RepresentationsBuilder setIndexDisclaimer(Boolean indexDisclaimer);
		Representations.RepresentationsBuilder setAdditionalAcknowledgements(Boolean additionalAcknowledgements);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nonReliance"), Boolean.class, getNonReliance(), this);
			processor.processBasic(path.newSubPath("agreementsRegardingHedging"), Boolean.class, getAgreementsRegardingHedging(), this);
			processor.processBasic(path.newSubPath("indexDisclaimer"), Boolean.class, getIndexDisclaimer(), this);
			processor.processBasic(path.newSubPath("additionalAcknowledgements"), Boolean.class, getAdditionalAcknowledgements(), this);
		}
		

		Representations.RepresentationsBuilder prune();
	}

	/*********************** Immutable Implementation of Representations  ***********************/
	class RepresentationsImpl implements Representations {
		private final Boolean nonReliance;
		private final Boolean agreementsRegardingHedging;
		private final Boolean indexDisclaimer;
		private final Boolean additionalAcknowledgements;
		
		protected RepresentationsImpl(Representations.RepresentationsBuilder builder) {
			this.nonReliance = builder.getNonReliance();
			this.agreementsRegardingHedging = builder.getAgreementsRegardingHedging();
			this.indexDisclaimer = builder.getIndexDisclaimer();
			this.additionalAcknowledgements = builder.getAdditionalAcknowledgements();
		}
		
		@Override
		@RosettaAttribute("nonReliance")
		public Boolean getNonReliance() {
			return nonReliance;
		}
		
		@Override
		@RosettaAttribute("agreementsRegardingHedging")
		public Boolean getAgreementsRegardingHedging() {
			return agreementsRegardingHedging;
		}
		
		@Override
		@RosettaAttribute("indexDisclaimer")
		public Boolean getIndexDisclaimer() {
			return indexDisclaimer;
		}
		
		@Override
		@RosettaAttribute("additionalAcknowledgements")
		public Boolean getAdditionalAcknowledgements() {
			return additionalAcknowledgements;
		}
		
		@Override
		public Representations build() {
			return this;
		}
		
		@Override
		public Representations.RepresentationsBuilder toBuilder() {
			Representations.RepresentationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Representations.RepresentationsBuilder builder) {
			ofNullable(getNonReliance()).ifPresent(builder::setNonReliance);
			ofNullable(getAgreementsRegardingHedging()).ifPresent(builder::setAgreementsRegardingHedging);
			ofNullable(getIndexDisclaimer()).ifPresent(builder::setIndexDisclaimer);
			ofNullable(getAdditionalAcknowledgements()).ifPresent(builder::setAdditionalAcknowledgements);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Representations _that = getType().cast(o);
		
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			if (!Objects.equals(agreementsRegardingHedging, _that.getAgreementsRegardingHedging())) return false;
			if (!Objects.equals(indexDisclaimer, _that.getIndexDisclaimer())) return false;
			if (!Objects.equals(additionalAcknowledgements, _that.getAdditionalAcknowledgements())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			_result = 31 * _result + (agreementsRegardingHedging != null ? agreementsRegardingHedging.hashCode() : 0);
			_result = 31 * _result + (indexDisclaimer != null ? indexDisclaimer.hashCode() : 0);
			_result = 31 * _result + (additionalAcknowledgements != null ? additionalAcknowledgements.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Representations {" +
				"nonReliance=" + this.nonReliance + ", " +
				"agreementsRegardingHedging=" + this.agreementsRegardingHedging + ", " +
				"indexDisclaimer=" + this.indexDisclaimer + ", " +
				"additionalAcknowledgements=" + this.additionalAcknowledgements +
			'}';
		}
	}

	/*********************** Builder Implementation of Representations  ***********************/
	class RepresentationsBuilderImpl implements Representations.RepresentationsBuilder {
	
		protected Boolean nonReliance;
		protected Boolean agreementsRegardingHedging;
		protected Boolean indexDisclaimer;
		protected Boolean additionalAcknowledgements;
	
		public RepresentationsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("nonReliance")
		public Boolean getNonReliance() {
			return nonReliance;
		}
		
		@Override
		@RosettaAttribute("agreementsRegardingHedging")
		public Boolean getAgreementsRegardingHedging() {
			return agreementsRegardingHedging;
		}
		
		@Override
		@RosettaAttribute("indexDisclaimer")
		public Boolean getIndexDisclaimer() {
			return indexDisclaimer;
		}
		
		@Override
		@RosettaAttribute("additionalAcknowledgements")
		public Boolean getAdditionalAcknowledgements() {
			return additionalAcknowledgements;
		}
		
		@Override
		@RosettaAttribute("nonReliance")
		public Representations.RepresentationsBuilder setNonReliance(Boolean nonReliance) {
			this.nonReliance = nonReliance==null?null:nonReliance;
			return this;
		}
		@Override
		@RosettaAttribute("agreementsRegardingHedging")
		public Representations.RepresentationsBuilder setAgreementsRegardingHedging(Boolean agreementsRegardingHedging) {
			this.agreementsRegardingHedging = agreementsRegardingHedging==null?null:agreementsRegardingHedging;
			return this;
		}
		@Override
		@RosettaAttribute("indexDisclaimer")
		public Representations.RepresentationsBuilder setIndexDisclaimer(Boolean indexDisclaimer) {
			this.indexDisclaimer = indexDisclaimer==null?null:indexDisclaimer;
			return this;
		}
		@Override
		@RosettaAttribute("additionalAcknowledgements")
		public Representations.RepresentationsBuilder setAdditionalAcknowledgements(Boolean additionalAcknowledgements) {
			this.additionalAcknowledgements = additionalAcknowledgements==null?null:additionalAcknowledgements;
			return this;
		}
		
		@Override
		public Representations build() {
			return new Representations.RepresentationsImpl(this);
		}
		
		@Override
		public Representations.RepresentationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Representations.RepresentationsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNonReliance()!=null) return true;
			if (getAgreementsRegardingHedging()!=null) return true;
			if (getIndexDisclaimer()!=null) return true;
			if (getAdditionalAcknowledgements()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Representations.RepresentationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Representations.RepresentationsBuilder o = (Representations.RepresentationsBuilder) other;
			
			
			merger.mergeBasic(getNonReliance(), o.getNonReliance(), this::setNonReliance);
			merger.mergeBasic(getAgreementsRegardingHedging(), o.getAgreementsRegardingHedging(), this::setAgreementsRegardingHedging);
			merger.mergeBasic(getIndexDisclaimer(), o.getIndexDisclaimer(), this::setIndexDisclaimer);
			merger.mergeBasic(getAdditionalAcknowledgements(), o.getAdditionalAcknowledgements(), this::setAdditionalAcknowledgements);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Representations _that = getType().cast(o);
		
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			if (!Objects.equals(agreementsRegardingHedging, _that.getAgreementsRegardingHedging())) return false;
			if (!Objects.equals(indexDisclaimer, _that.getIndexDisclaimer())) return false;
			if (!Objects.equals(additionalAcknowledgements, _that.getAdditionalAcknowledgements())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			_result = 31 * _result + (agreementsRegardingHedging != null ? agreementsRegardingHedging.hashCode() : 0);
			_result = 31 * _result + (indexDisclaimer != null ? indexDisclaimer.hashCode() : 0);
			_result = 31 * _result + (additionalAcknowledgements != null ? additionalAcknowledgements.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepresentationsBuilder {" +
				"nonReliance=" + this.nonReliance + ", " +
				"agreementsRegardingHedging=" + this.agreementsRegardingHedging + ", " +
				"indexDisclaimer=" + this.indexDisclaimer + ", " +
				"additionalAcknowledgements=" + this.additionalAcknowledgements +
			'}';
		}
	}
}
