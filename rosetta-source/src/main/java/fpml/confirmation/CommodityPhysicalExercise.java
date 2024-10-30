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
import fpml.confirmation.CommodityPhysicalAmericanExercise;
import fpml.confirmation.CommodityPhysicalEuropeanExercise;
import fpml.confirmation.CommodityPhysicalExercise;
import fpml.confirmation.CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder;
import fpml.confirmation.CommodityPhysicalExercise.CommodityPhysicalExerciseBuilderImpl;
import fpml.confirmation.CommodityPhysicalExercise.CommodityPhysicalExerciseImpl;
import fpml.confirmation.SwaptionPhysicalSettlement;
import fpml.confirmation.meta.CommodityPhysicalExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The parameters for defining how the physically-settled commodity option can be exercised and how it is settled.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityPhysicalExercise", builder=CommodityPhysicalExercise.CommodityPhysicalExerciseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityPhysicalExercise extends RosettaModelObject {

	CommodityPhysicalExerciseMeta metaData = new CommodityPhysicalExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parameters for defining the expiration date(s) and time(s) for an American style option.
	 */
	CommodityPhysicalAmericanExercise getAmericanExercise();
	/**
	 * The parameters for defining the expiration date(s) and time(s) for a European style option.
	 */
	CommodityPhysicalEuropeanExercise getEuropeanExercise();
	/**
	 * Specifies whether or not Automatic Exercise applies to a Commodity Option Transaction.
	 */
	Boolean getAutomaticExercise();
	/**
	 * Specifies whether or not Written Confirmation applies to a Commodity Option Transaction.
	 */
	Boolean getWrittenConfirmation();
	/**
	 * Specifies any instructions on how the physical settlement is to be effected when the option is exercised.
	 */
	SwaptionPhysicalSettlement getClearingInstructions();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalExercise build();
	
	CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder toBuilder();
	
	static CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder builder() {
		return new CommodityPhysicalExercise.CommodityPhysicalExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPhysicalExercise> getType() {
		return CommodityPhysicalExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("americanExercise"), processor, CommodityPhysicalAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, CommodityPhysicalEuropeanExercise.class, getEuropeanExercise());
		processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
		processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
		processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.class, getClearingInstructions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalExerciseBuilder extends CommodityPhysicalExercise, RosettaModelObjectBuilder {
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder getOrCreateAmericanExercise();
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder getAmericanExercise();
		CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder getEuropeanExercise();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions();
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setAmericanExercise(CommodityPhysicalAmericanExercise americanExercise);
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setEuropeanExercise(CommodityPhysicalEuropeanExercise europeanExercise);
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setAutomaticExercise(Boolean automaticExercise);
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setWrittenConfirmation(Boolean writtenConfirmation);
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("americanExercise"), processor, CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder.class, getEuropeanExercise());
			processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
			processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
			processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder.class, getClearingInstructions());
		}
		

		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalExercise  ***********************/
	class CommodityPhysicalExerciseImpl implements CommodityPhysicalExercise {
		private final CommodityPhysicalAmericanExercise americanExercise;
		private final CommodityPhysicalEuropeanExercise europeanExercise;
		private final Boolean automaticExercise;
		private final Boolean writtenConfirmation;
		private final SwaptionPhysicalSettlement clearingInstructions;
		
		protected CommodityPhysicalExerciseImpl(CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder builder) {
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.automaticExercise = builder.getAutomaticExercise();
			this.writtenConfirmation = builder.getWrittenConfirmation();
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		public CommodityPhysicalAmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		public CommodityPhysicalEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("writtenConfirmation")
		public Boolean getWrittenConfirmation() {
			return writtenConfirmation;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public CommodityPhysicalExercise build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder toBuilder() {
			CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder builder) {
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
			ofNullable(getWrittenConfirmation()).ifPresent(builder::setWrittenConfirmation);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalExercise _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (writtenConfirmation != null ? writtenConfirmation.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalExercise {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"clearingInstructions=" + this.clearingInstructions +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalExercise  ***********************/
	class CommodityPhysicalExerciseBuilderImpl implements CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder {
	
		protected CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder americanExercise;
		protected CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder europeanExercise;
		protected Boolean automaticExercise;
		protected Boolean writtenConfirmation;
		protected SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder clearingInstructions;
	
		public CommodityPhysicalExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("americanExercise")
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder getOrCreateAmericanExercise() {
			CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = CommodityPhysicalAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = CommodityPhysicalEuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("writtenConfirmation")
		public Boolean getWrittenConfirmation() {
			return writtenConfirmation;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions() {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder result;
			if (clearingInstructions!=null) {
				result = clearingInstructions;
			}
			else {
				result = clearingInstructions = SwaptionPhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setAmericanExercise(CommodityPhysicalAmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("europeanExercise")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setEuropeanExercise(CommodityPhysicalEuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("automaticExercise")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setAutomaticExercise(Boolean automaticExercise) {
			this.automaticExercise = automaticExercise==null?null:automaticExercise;
			return this;
		}
		@Override
		@RosettaAttribute("writtenConfirmation")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setWrittenConfirmation(Boolean writtenConfirmation) {
			this.writtenConfirmation = writtenConfirmation==null?null:writtenConfirmation;
			return this;
		}
		@Override
		@RosettaAttribute("clearingInstructions")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions) {
			this.clearingInstructions = clearingInstructions==null?null:clearingInstructions.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalExercise build() {
			return new CommodityPhysicalExercise.CommodityPhysicalExerciseImpl(this);
		}
		
		@Override
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder prune() {
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getAutomaticExercise()!=null) return true;
			if (getWrittenConfirmation()!=null) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder o = (CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			
			merger.mergeBasic(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			merger.mergeBasic(getWrittenConfirmation(), o.getWrittenConfirmation(), this::setWrittenConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalExercise _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (writtenConfirmation != null ? writtenConfirmation.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalExerciseBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"clearingInstructions=" + this.clearingInstructions +
			'}';
		}
	}
}
