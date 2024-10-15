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
import fpml.confirmation.PortfolioReference;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.PortfolioReferenceModel.PortfolioReferenceModelBuilder;
import fpml.confirmation.PortfolioReferenceModel.PortfolioReferenceModelBuilderImpl;
import fpml.confirmation.PortfolioReferenceModel.PortfolioReferenceModelImpl;
import fpml.confirmation.meta.PortfolioReferenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a model group that allows a portfolio reference request structure to be included in a message.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioReferenceModel", builder=PortfolioReferenceModel.PortfolioReferenceModelBuilderImpl.class, version="${project.version}")
public interface PortfolioReferenceModel extends RosettaModelObject {

	PortfolioReferenceModelMeta metaData = new PortfolioReferenceModelMeta();

	/*********************** Getter Methods  ***********************/
	PortfolioReference getPortfolioReference();

	/*********************** Build Methods  ***********************/
	PortfolioReferenceModel build();
	
	PortfolioReferenceModel.PortfolioReferenceModelBuilder toBuilder();
	
	static PortfolioReferenceModel.PortfolioReferenceModelBuilder builder() {
		return new PortfolioReferenceModel.PortfolioReferenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioReferenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PortfolioReferenceModel> getType() {
		return PortfolioReferenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioReference.class, getPortfolioReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioReferenceModelBuilder extends PortfolioReferenceModel, RosettaModelObjectBuilder {
		PortfolioReference.PortfolioReferenceBuilder getOrCreatePortfolioReference();
		PortfolioReference.PortfolioReferenceBuilder getPortfolioReference();
		PortfolioReferenceModel.PortfolioReferenceModelBuilder setPortfolioReference(PortfolioReference portfolioReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioReference.PortfolioReferenceBuilder.class, getPortfolioReference());
		}
		

		PortfolioReferenceModel.PortfolioReferenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioReferenceModel  ***********************/
	class PortfolioReferenceModelImpl implements PortfolioReferenceModel {
		private final PortfolioReference portfolioReference;
		
		protected PortfolioReferenceModelImpl(PortfolioReferenceModel.PortfolioReferenceModelBuilder builder) {
			this.portfolioReference = ofNullable(builder.getPortfolioReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioReference getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		public PortfolioReferenceModel build() {
			return this;
		}
		
		@Override
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder toBuilder() {
			PortfolioReferenceModel.PortfolioReferenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioReferenceModel.PortfolioReferenceModelBuilder builder) {
			ofNullable(getPortfolioReference()).ifPresent(builder::setPortfolioReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReference, _that.getPortfolioReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolioReference != null ? portfolioReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceModel {" +
				"portfolioReference=" + this.portfolioReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioReferenceModel  ***********************/
	class PortfolioReferenceModelBuilderImpl implements PortfolioReferenceModel.PortfolioReferenceModelBuilder {
	
		protected PortfolioReference.PortfolioReferenceBuilder portfolioReference;
	
		public PortfolioReferenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioReference.PortfolioReferenceBuilder getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		public PortfolioReference.PortfolioReferenceBuilder getOrCreatePortfolioReference() {
			PortfolioReference.PortfolioReferenceBuilder result;
			if (portfolioReference!=null) {
				result = portfolioReference;
			}
			else {
				result = portfolioReference = PortfolioReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder setPortfolioReference(PortfolioReference portfolioReference) {
			this.portfolioReference = portfolioReference==null?null:portfolioReference.toBuilder();
			return this;
		}
		
		@Override
		public PortfolioReferenceModel build() {
			return new PortfolioReferenceModel.PortfolioReferenceModelImpl(this);
		}
		
		@Override
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder prune() {
			if (portfolioReference!=null && !portfolioReference.prune().hasData()) portfolioReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPortfolioReference()!=null && getPortfolioReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioReferenceModel.PortfolioReferenceModelBuilder o = (PortfolioReferenceModel.PortfolioReferenceModelBuilder) other;
			
			merger.mergeRosetta(getPortfolioReference(), o.getPortfolioReference(), this::setPortfolioReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReference, _that.getPortfolioReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolioReference != null ? portfolioReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceModelBuilder {" +
				"portfolioReference=" + this.portfolioReference +
			'}';
		}
	}
}
