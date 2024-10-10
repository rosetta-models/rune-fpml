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
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.PriceSequence;
import fpml.confirmation.PriceSequence.PriceSequenceBuilder;
import fpml.confirmation.PriceSequence.PriceSequenceBuilderImpl;
import fpml.confirmation.PriceSequence.PriceSequenceImpl;
import fpml.confirmation.meta.PriceSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PriceSequence", builder=PriceSequence.PriceSequenceBuilderImpl.class, version="${project.version}")
public interface PriceSequence extends RosettaModelObject {

	PriceSequenceMeta metaData = new PriceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the method according to which an amount or a date is determined.
	 */
	DeterminationMethod getDeterminationMethod();
	EquityPriceModel getEquityPriceModel();

	/*********************** Build Methods  ***********************/
	PriceSequence build();
	
	PriceSequence.PriceSequenceBuilder toBuilder();
	
	static PriceSequence.PriceSequenceBuilder builder() {
		return new PriceSequence.PriceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PriceSequence> getType() {
		return PriceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("equityPriceModel"), processor, EquityPriceModel.class, getEquityPriceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceSequenceBuilder extends PriceSequence, RosettaModelObjectBuilder {
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		EquityPriceModel.EquityPriceModelBuilder getOrCreateEquityPriceModel();
		EquityPriceModel.EquityPriceModelBuilder getEquityPriceModel();
		PriceSequence.PriceSequenceBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		PriceSequence.PriceSequenceBuilder setEquityPriceModel(EquityPriceModel equityPriceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("equityPriceModel"), processor, EquityPriceModel.EquityPriceModelBuilder.class, getEquityPriceModel());
		}
		

		PriceSequence.PriceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of PriceSequence  ***********************/
	class PriceSequenceImpl implements PriceSequence {
		private final DeterminationMethod determinationMethod;
		private final EquityPriceModel equityPriceModel;
		
		protected PriceSequenceImpl(PriceSequence.PriceSequenceBuilder builder) {
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.equityPriceModel = ofNullable(builder.getEquityPriceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("equityPriceModel")
		public EquityPriceModel getEquityPriceModel() {
			return equityPriceModel;
		}
		
		@Override
		public PriceSequence build() {
			return this;
		}
		
		@Override
		public PriceSequence.PriceSequenceBuilder toBuilder() {
			PriceSequence.PriceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceSequence.PriceSequenceBuilder builder) {
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getEquityPriceModel()).ifPresent(builder::setEquityPriceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceSequence _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(equityPriceModel, _that.getEquityPriceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (equityPriceModel != null ? equityPriceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceSequence {" +
				"determinationMethod=" + this.determinationMethod + ", " +
				"equityPriceModel=" + this.equityPriceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceSequence  ***********************/
	class PriceSequenceBuilderImpl implements PriceSequence.PriceSequenceBuilder {
	
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected EquityPriceModel.EquityPriceModelBuilder equityPriceModel;
	
		public PriceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityPriceModel")
		public EquityPriceModel.EquityPriceModelBuilder getEquityPriceModel() {
			return equityPriceModel;
		}
		
		@Override
		public EquityPriceModel.EquityPriceModelBuilder getOrCreateEquityPriceModel() {
			EquityPriceModel.EquityPriceModelBuilder result;
			if (equityPriceModel!=null) {
				result = equityPriceModel;
			}
			else {
				result = equityPriceModel = EquityPriceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public PriceSequence.PriceSequenceBuilder setDeterminationMethod(DeterminationMethod determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityPriceModel")
		public PriceSequence.PriceSequenceBuilder setEquityPriceModel(EquityPriceModel equityPriceModel) {
			this.equityPriceModel = equityPriceModel==null?null:equityPriceModel.toBuilder();
			return this;
		}
		
		@Override
		public PriceSequence build() {
			return new PriceSequence.PriceSequenceImpl(this);
		}
		
		@Override
		public PriceSequence.PriceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSequence.PriceSequenceBuilder prune() {
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (equityPriceModel!=null && !equityPriceModel.prune().hasData()) equityPriceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getEquityPriceModel()!=null && getEquityPriceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSequence.PriceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceSequence.PriceSequenceBuilder o = (PriceSequence.PriceSequenceBuilder) other;
			
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getEquityPriceModel(), o.getEquityPriceModel(), this::setEquityPriceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceSequence _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(equityPriceModel, _that.getEquityPriceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (equityPriceModel != null ? equityPriceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceSequenceBuilder {" +
				"determinationMethod=" + this.determinationMethod + ", " +
				"equityPriceModel=" + this.equityPriceModel +
			'}';
		}
	}
}
