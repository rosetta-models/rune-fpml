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
import fpml.confirmation.IssuerTradeId;
import fpml.confirmation.IssuerTradeId.IssuerTradeIdBuilder;
import fpml.confirmation.IssuerTradeId.IssuerTradeIdBuilderImpl;
import fpml.confirmation.IssuerTradeId.IssuerTradeIdImpl;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.meta.IssuerTradeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A complex type for a two part identifier such as a USI.
 * @version ${project.version}
 */
@RosettaDataType(value="IssuerTradeId", builder=IssuerTradeId.IssuerTradeIdBuilderImpl.class, version="${project.version}")
public interface IssuerTradeId extends RosettaModelObject {

	IssuerTradeIdMeta metaData = new IssuerTradeIdMeta();

	/*********************** Getter Methods  ***********************/
	IssuerTradeIdModel getIssuerTradeIdModel();

	/*********************** Build Methods  ***********************/
	IssuerTradeId build();
	
	IssuerTradeId.IssuerTradeIdBuilder toBuilder();
	
	static IssuerTradeId.IssuerTradeIdBuilder builder() {
		return new IssuerTradeId.IssuerTradeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IssuerTradeId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IssuerTradeId> getType() {
		return IssuerTradeId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.class, getIssuerTradeIdModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IssuerTradeIdBuilder extends IssuerTradeId, RosettaModelObjectBuilder {
		IssuerTradeIdModel.IssuerTradeIdModelBuilder getOrCreateIssuerTradeIdModel();
		IssuerTradeIdModel.IssuerTradeIdModelBuilder getIssuerTradeIdModel();
		IssuerTradeId.IssuerTradeIdBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.IssuerTradeIdModelBuilder.class, getIssuerTradeIdModel());
		}
		

		IssuerTradeId.IssuerTradeIdBuilder prune();
	}

	/*********************** Immutable Implementation of IssuerTradeId  ***********************/
	class IssuerTradeIdImpl implements IssuerTradeId {
		private final IssuerTradeIdModel issuerTradeIdModel;
		
		protected IssuerTradeIdImpl(IssuerTradeId.IssuerTradeIdBuilder builder) {
			this.issuerTradeIdModel = ofNullable(builder.getIssuerTradeIdModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public IssuerTradeIdModel getIssuerTradeIdModel() {
			return issuerTradeIdModel;
		}
		
		@Override
		public IssuerTradeId build() {
			return this;
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder toBuilder() {
			IssuerTradeId.IssuerTradeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerTradeId.IssuerTradeIdBuilder builder) {
			ofNullable(getIssuerTradeIdModel()).ifPresent(builder::setIssuerTradeIdModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerTradeId _that = getType().cast(o);
		
			if (!Objects.equals(issuerTradeIdModel, _that.getIssuerTradeIdModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerTradeIdModel != null ? issuerTradeIdModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerTradeId {" +
				"issuerTradeIdModel=" + this.issuerTradeIdModel +
			'}';
		}
	}

	/*********************** Builder Implementation of IssuerTradeId  ***********************/
	class IssuerTradeIdBuilderImpl implements IssuerTradeId.IssuerTradeIdBuilder {
	
		protected IssuerTradeIdModel.IssuerTradeIdModelBuilder issuerTradeIdModel;
	
		public IssuerTradeIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder getIssuerTradeIdModel() {
			return issuerTradeIdModel;
		}
		
		@Override
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder getOrCreateIssuerTradeIdModel() {
			IssuerTradeIdModel.IssuerTradeIdModelBuilder result;
			if (issuerTradeIdModel!=null) {
				result = issuerTradeIdModel;
			}
			else {
				result = issuerTradeIdModel = IssuerTradeIdModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public IssuerTradeId.IssuerTradeIdBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel) {
			this.issuerTradeIdModel = issuerTradeIdModel==null?null:issuerTradeIdModel.toBuilder();
			return this;
		}
		
		@Override
		public IssuerTradeId build() {
			return new IssuerTradeId.IssuerTradeIdImpl(this);
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder prune() {
			if (issuerTradeIdModel!=null && !issuerTradeIdModel.prune().hasData()) issuerTradeIdModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuerTradeIdModel()!=null && getIssuerTradeIdModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerTradeId.IssuerTradeIdBuilder o = (IssuerTradeId.IssuerTradeIdBuilder) other;
			
			merger.mergeRosetta(getIssuerTradeIdModel(), o.getIssuerTradeIdModel(), this::setIssuerTradeIdModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerTradeId _that = getType().cast(o);
		
			if (!Objects.equals(issuerTradeIdModel, _that.getIssuerTradeIdModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerTradeIdModel != null ? issuerTradeIdModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerTradeIdBuilder {" +
				"issuerTradeIdModel=" + this.issuerTradeIdModel +
			'}';
		}
	}
}
