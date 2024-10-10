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
import fpml.confirmation.PortfolioConstituentReference;
import fpml.confirmation.PortfolioConstituentReferenceModel;
import fpml.confirmation.PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder;
import fpml.confirmation.PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilderImpl;
import fpml.confirmation.PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelImpl;
import fpml.confirmation.meta.PortfolioConstituentReferenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a model group that allows a constituent of a portfolio to be included in a request retransmission message.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioConstituentReferenceModel", builder=PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilderImpl.class, version="${project.version}")
public interface PortfolioConstituentReferenceModel extends RosettaModelObject {

	PortfolioConstituentReferenceModelMeta metaData = new PortfolioConstituentReferenceModelMeta();

	/*********************** Getter Methods  ***********************/
	PortfolioConstituentReference getPortfolioReference();

	/*********************** Build Methods  ***********************/
	PortfolioConstituentReferenceModel build();
	
	PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder toBuilder();
	
	static PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder builder() {
		return new PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioConstituentReferenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PortfolioConstituentReferenceModel> getType() {
		return PortfolioConstituentReferenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioConstituentReference.class, getPortfolioReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioConstituentReferenceModelBuilder extends PortfolioConstituentReferenceModel, RosettaModelObjectBuilder {
		PortfolioConstituentReference.PortfolioConstituentReferenceBuilder getOrCreatePortfolioReference();
		PortfolioConstituentReference.PortfolioConstituentReferenceBuilder getPortfolioReference();
		PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder setPortfolioReference(PortfolioConstituentReference portfolioReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioConstituentReference.PortfolioConstituentReferenceBuilder.class, getPortfolioReference());
		}
		

		PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioConstituentReferenceModel  ***********************/
	class PortfolioConstituentReferenceModelImpl implements PortfolioConstituentReferenceModel {
		private final PortfolioConstituentReference portfolioReference;
		
		protected PortfolioConstituentReferenceModelImpl(PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder builder) {
			this.portfolioReference = ofNullable(builder.getPortfolioReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioConstituentReference getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		public PortfolioConstituentReferenceModel build() {
			return this;
		}
		
		@Override
		public PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder toBuilder() {
			PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder builder) {
			ofNullable(getPortfolioReference()).ifPresent(builder::setPortfolioReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioConstituentReferenceModel _that = getType().cast(o);
		
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
			return "PortfolioConstituentReferenceModel {" +
				"portfolioReference=" + this.portfolioReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioConstituentReferenceModel  ***********************/
	class PortfolioConstituentReferenceModelBuilderImpl implements PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder {
	
		protected PortfolioConstituentReference.PortfolioConstituentReferenceBuilder portfolioReference;
	
		public PortfolioConstituentReferenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder getOrCreatePortfolioReference() {
			PortfolioConstituentReference.PortfolioConstituentReferenceBuilder result;
			if (portfolioReference!=null) {
				result = portfolioReference;
			}
			else {
				result = portfolioReference = PortfolioConstituentReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder setPortfolioReference(PortfolioConstituentReference portfolioReference) {
			this.portfolioReference = portfolioReference==null?null:portfolioReference.toBuilder();
			return this;
		}
		
		@Override
		public PortfolioConstituentReferenceModel build() {
			return new PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelImpl(this);
		}
		
		@Override
		public PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder prune() {
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
		public PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder o = (PortfolioConstituentReferenceModel.PortfolioConstituentReferenceModelBuilder) other;
			
			merger.mergeRosetta(getPortfolioReference(), o.getPortfolioReference(), this::setPortfolioReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioConstituentReferenceModel _that = getType().cast(o);
		
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
			return "PortfolioConstituentReferenceModelBuilder {" +
				"portfolioReference=" + this.portfolioReference +
			'}';
		}
	}
}
