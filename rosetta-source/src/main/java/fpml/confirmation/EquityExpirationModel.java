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
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.EquityExpirationModel.EquityExpirationModelBuilder;
import fpml.confirmation.EquityExpirationModel.EquityExpirationModelBuilderImpl;
import fpml.confirmation.EquityExpirationModel.EquityExpirationModelImpl;
import fpml.confirmation.EquityExpirationModelSequence;
import fpml.confirmation.meta.EquityExpirationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between expiration expressed as symbolic and optional literal time, or using a determination method.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityExpirationModel", builder=EquityExpirationModel.EquityExpirationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityExpirationModel extends RosettaModelObject {

	EquityExpirationModelMeta metaData = new EquityExpirationModelMeta();

	/*********************** Getter Methods  ***********************/
	EquityExpirationModelSequence getEquityExpirationModelSequence();
	/**
	 * Expiration time determination method.
	 */
	DeterminationMethod getExpirationTimeDetermination();

	/*********************** Build Methods  ***********************/
	EquityExpirationModel build();
	
	EquityExpirationModel.EquityExpirationModelBuilder toBuilder();
	
	static EquityExpirationModel.EquityExpirationModelBuilder builder() {
		return new EquityExpirationModel.EquityExpirationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityExpirationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityExpirationModel> getType() {
		return EquityExpirationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("equityExpirationModelSequence"), processor, EquityExpirationModelSequence.class, getEquityExpirationModelSequence());
		processRosetta(path.newSubPath("expirationTimeDetermination"), processor, DeterminationMethod.class, getExpirationTimeDetermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityExpirationModelBuilder extends EquityExpirationModel, RosettaModelObjectBuilder {
		EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder getOrCreateEquityExpirationModelSequence();
		EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder getEquityExpirationModelSequence();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateExpirationTimeDetermination();
		DeterminationMethod.DeterminationMethodBuilder getExpirationTimeDetermination();
		EquityExpirationModel.EquityExpirationModelBuilder setEquityExpirationModelSequence(EquityExpirationModelSequence equityExpirationModelSequence);
		EquityExpirationModel.EquityExpirationModelBuilder setExpirationTimeDetermination(DeterminationMethod expirationTimeDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("equityExpirationModelSequence"), processor, EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder.class, getEquityExpirationModelSequence());
			processRosetta(path.newSubPath("expirationTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getExpirationTimeDetermination());
		}
		

		EquityExpirationModel.EquityExpirationModelBuilder prune();
	}

	/*********************** Immutable Implementation of EquityExpirationModel  ***********************/
	class EquityExpirationModelImpl implements EquityExpirationModel {
		private final EquityExpirationModelSequence equityExpirationModelSequence;
		private final DeterminationMethod expirationTimeDetermination;
		
		protected EquityExpirationModelImpl(EquityExpirationModel.EquityExpirationModelBuilder builder) {
			this.equityExpirationModelSequence = ofNullable(builder.getEquityExpirationModelSequence()).map(f->f.build()).orElse(null);
			this.expirationTimeDetermination = ofNullable(builder.getExpirationTimeDetermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("equityExpirationModelSequence")
		public EquityExpirationModelSequence getEquityExpirationModelSequence() {
			return equityExpirationModelSequence;
		}
		
		@Override
		@RosettaAttribute("expirationTimeDetermination")
		public DeterminationMethod getExpirationTimeDetermination() {
			return expirationTimeDetermination;
		}
		
		@Override
		public EquityExpirationModel build() {
			return this;
		}
		
		@Override
		public EquityExpirationModel.EquityExpirationModelBuilder toBuilder() {
			EquityExpirationModel.EquityExpirationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityExpirationModel.EquityExpirationModelBuilder builder) {
			ofNullable(getEquityExpirationModelSequence()).ifPresent(builder::setEquityExpirationModelSequence);
			ofNullable(getExpirationTimeDetermination()).ifPresent(builder::setExpirationTimeDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExpirationModel _that = getType().cast(o);
		
			if (!Objects.equals(equityExpirationModelSequence, _that.getEquityExpirationModelSequence())) return false;
			if (!Objects.equals(expirationTimeDetermination, _that.getExpirationTimeDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (equityExpirationModelSequence != null ? equityExpirationModelSequence.hashCode() : 0);
			_result = 31 * _result + (expirationTimeDetermination != null ? expirationTimeDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExpirationModel {" +
				"equityExpirationModelSequence=" + this.equityExpirationModelSequence + ", " +
				"expirationTimeDetermination=" + this.expirationTimeDetermination +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityExpirationModel  ***********************/
	class EquityExpirationModelBuilderImpl implements EquityExpirationModel.EquityExpirationModelBuilder {
	
		protected EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder equityExpirationModelSequence;
		protected DeterminationMethod.DeterminationMethodBuilder expirationTimeDetermination;
	
		public EquityExpirationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("equityExpirationModelSequence")
		public EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder getEquityExpirationModelSequence() {
			return equityExpirationModelSequence;
		}
		
		@Override
		public EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder getOrCreateEquityExpirationModelSequence() {
			EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder result;
			if (equityExpirationModelSequence!=null) {
				result = equityExpirationModelSequence;
			}
			else {
				result = equityExpirationModelSequence = EquityExpirationModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTimeDetermination")
		public DeterminationMethod.DeterminationMethodBuilder getExpirationTimeDetermination() {
			return expirationTimeDetermination;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateExpirationTimeDetermination() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (expirationTimeDetermination!=null) {
				result = expirationTimeDetermination;
			}
			else {
				result = expirationTimeDetermination = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityExpirationModelSequence")
		public EquityExpirationModel.EquityExpirationModelBuilder setEquityExpirationModelSequence(EquityExpirationModelSequence equityExpirationModelSequence) {
			this.equityExpirationModelSequence = equityExpirationModelSequence==null?null:equityExpirationModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationTimeDetermination")
		public EquityExpirationModel.EquityExpirationModelBuilder setExpirationTimeDetermination(DeterminationMethod expirationTimeDetermination) {
			this.expirationTimeDetermination = expirationTimeDetermination==null?null:expirationTimeDetermination.toBuilder();
			return this;
		}
		
		@Override
		public EquityExpirationModel build() {
			return new EquityExpirationModel.EquityExpirationModelImpl(this);
		}
		
		@Override
		public EquityExpirationModel.EquityExpirationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExpirationModel.EquityExpirationModelBuilder prune() {
			if (equityExpirationModelSequence!=null && !equityExpirationModelSequence.prune().hasData()) equityExpirationModelSequence = null;
			if (expirationTimeDetermination!=null && !expirationTimeDetermination.prune().hasData()) expirationTimeDetermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEquityExpirationModelSequence()!=null && getEquityExpirationModelSequence().hasData()) return true;
			if (getExpirationTimeDetermination()!=null && getExpirationTimeDetermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExpirationModel.EquityExpirationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityExpirationModel.EquityExpirationModelBuilder o = (EquityExpirationModel.EquityExpirationModelBuilder) other;
			
			merger.mergeRosetta(getEquityExpirationModelSequence(), o.getEquityExpirationModelSequence(), this::setEquityExpirationModelSequence);
			merger.mergeRosetta(getExpirationTimeDetermination(), o.getExpirationTimeDetermination(), this::setExpirationTimeDetermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExpirationModel _that = getType().cast(o);
		
			if (!Objects.equals(equityExpirationModelSequence, _that.getEquityExpirationModelSequence())) return false;
			if (!Objects.equals(expirationTimeDetermination, _that.getExpirationTimeDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (equityExpirationModelSequence != null ? equityExpirationModelSequence.hashCode() : 0);
			_result = 31 * _result + (expirationTimeDetermination != null ? expirationTimeDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExpirationModelBuilder {" +
				"equityExpirationModelSequence=" + this.equityExpirationModelSequence + ", " +
				"expirationTimeDetermination=" + this.expirationTimeDetermination +
			'}';
		}
	}
}
