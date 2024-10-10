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
import fpml.confirmation.CountryCode;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder;
import fpml.confirmation.EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilderImpl;
import fpml.confirmation.EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelImpl;
import fpml.confirmation.IndexAnnexFallbackModel;
import fpml.confirmation.meta.EquityUnderlyerProvisionsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group containing Equity Underlyer provisions.
 * @version ${project.version}
 */
@RosettaDataType(value="EquityUnderlyerProvisionsModel", builder=EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilderImpl.class, version="${project.version}")
public interface EquityUnderlyerProvisionsModel extends RosettaModelObject {

	EquityUnderlyerProvisionsModelMeta metaData = new EquityUnderlyerProvisionsModelMeta();

	/*********************** Getter Methods  ***********************/
	IndexAnnexFallbackModel getIndexAnnexFallbackModel();
	/**
	 * Local Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties, and similar charges imposed by the taxing authority of the Local Jurisdiction If this element is not present Local Jurisdiction is Not Applicable.
	 */
	CountryCode getLocalJurisdiction();
	/**
	 * Relevent Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties and similar charges that would be imposed by the taxing authority of the Country of Underlyer on a Hypothetical Broker Dealer assuming the Applicable Hedge Positions are held by its office in the Relevant Jurisdiction. If this element is not present Relevant Jurisdiction is Not Applicable.
	 */
	CountryCode getRelevantJurisdiction();

	/*********************** Build Methods  ***********************/
	EquityUnderlyerProvisionsModel build();
	
	EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder toBuilder();
	
	static EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder builder() {
		return new EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityUnderlyerProvisionsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityUnderlyerProvisionsModel> getType() {
		return EquityUnderlyerProvisionsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("indexAnnexFallbackModel"), processor, IndexAnnexFallbackModel.class, getIndexAnnexFallbackModel());
		processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.class, getLocalJurisdiction());
		processRosetta(path.newSubPath("relevantJurisdiction"), processor, CountryCode.class, getRelevantJurisdiction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityUnderlyerProvisionsModelBuilder extends EquityUnderlyerProvisionsModel, RosettaModelObjectBuilder {
		IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder getOrCreateIndexAnnexFallbackModel();
		IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder getIndexAnnexFallbackModel();
		CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction();
		CountryCode.CountryCodeBuilder getLocalJurisdiction();
		CountryCode.CountryCodeBuilder getOrCreateRelevantJurisdiction();
		CountryCode.CountryCodeBuilder getRelevantJurisdiction();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder setIndexAnnexFallbackModel(IndexAnnexFallbackModel indexAnnexFallbackModel);
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder setLocalJurisdiction(CountryCode localJurisdiction);
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder setRelevantJurisdiction(CountryCode relevantJurisdiction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("indexAnnexFallbackModel"), processor, IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder.class, getIndexAnnexFallbackModel());
			processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getLocalJurisdiction());
			processRosetta(path.newSubPath("relevantJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getRelevantJurisdiction());
		}
		

		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder prune();
	}

	/*********************** Immutable Implementation of EquityUnderlyerProvisionsModel  ***********************/
	class EquityUnderlyerProvisionsModelImpl implements EquityUnderlyerProvisionsModel {
		private final IndexAnnexFallbackModel indexAnnexFallbackModel;
		private final CountryCode localJurisdiction;
		private final CountryCode relevantJurisdiction;
		
		protected EquityUnderlyerProvisionsModelImpl(EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder builder) {
			this.indexAnnexFallbackModel = ofNullable(builder.getIndexAnnexFallbackModel()).map(f->f.build()).orElse(null);
			this.localJurisdiction = ofNullable(builder.getLocalJurisdiction()).map(f->f.build()).orElse(null);
			this.relevantJurisdiction = ofNullable(builder.getRelevantJurisdiction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indexAnnexFallbackModel")
		public IndexAnnexFallbackModel getIndexAnnexFallbackModel() {
			return indexAnnexFallbackModel;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		public CountryCode getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		@RosettaAttribute("relevantJurisdiction")
		public CountryCode getRelevantJurisdiction() {
			return relevantJurisdiction;
		}
		
		@Override
		public EquityUnderlyerProvisionsModel build() {
			return this;
		}
		
		@Override
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder toBuilder() {
			EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder builder) {
			ofNullable(getIndexAnnexFallbackModel()).ifPresent(builder::setIndexAnnexFallbackModel);
			ofNullable(getLocalJurisdiction()).ifPresent(builder::setLocalJurisdiction);
			ofNullable(getRelevantJurisdiction()).ifPresent(builder::setRelevantJurisdiction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityUnderlyerProvisionsModel _that = getType().cast(o);
		
			if (!Objects.equals(indexAnnexFallbackModel, _that.getIndexAnnexFallbackModel())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(relevantJurisdiction, _that.getRelevantJurisdiction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexAnnexFallbackModel != null ? indexAnnexFallbackModel.hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (relevantJurisdiction != null ? relevantJurisdiction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityUnderlyerProvisionsModel {" +
				"indexAnnexFallbackModel=" + this.indexAnnexFallbackModel + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"relevantJurisdiction=" + this.relevantJurisdiction +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityUnderlyerProvisionsModel  ***********************/
	class EquityUnderlyerProvisionsModelBuilderImpl implements EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder {
	
		protected IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder indexAnnexFallbackModel;
		protected CountryCode.CountryCodeBuilder localJurisdiction;
		protected CountryCode.CountryCodeBuilder relevantJurisdiction;
	
		public EquityUnderlyerProvisionsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("indexAnnexFallbackModel")
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder getIndexAnnexFallbackModel() {
			return indexAnnexFallbackModel;
		}
		
		@Override
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder getOrCreateIndexAnnexFallbackModel() {
			IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder result;
			if (indexAnnexFallbackModel!=null) {
				result = indexAnnexFallbackModel;
			}
			else {
				result = indexAnnexFallbackModel = IndexAnnexFallbackModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		public CountryCode.CountryCodeBuilder getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction() {
			CountryCode.CountryCodeBuilder result;
			if (localJurisdiction!=null) {
				result = localJurisdiction;
			}
			else {
				result = localJurisdiction = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relevantJurisdiction")
		public CountryCode.CountryCodeBuilder getRelevantJurisdiction() {
			return relevantJurisdiction;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateRelevantJurisdiction() {
			CountryCode.CountryCodeBuilder result;
			if (relevantJurisdiction!=null) {
				result = relevantJurisdiction;
			}
			else {
				result = relevantJurisdiction = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexAnnexFallbackModel")
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder setIndexAnnexFallbackModel(IndexAnnexFallbackModel indexAnnexFallbackModel) {
			this.indexAnnexFallbackModel = indexAnnexFallbackModel==null?null:indexAnnexFallbackModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("localJurisdiction")
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder setLocalJurisdiction(CountryCode localJurisdiction) {
			this.localJurisdiction = localJurisdiction==null?null:localJurisdiction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relevantJurisdiction")
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder setRelevantJurisdiction(CountryCode relevantJurisdiction) {
			this.relevantJurisdiction = relevantJurisdiction==null?null:relevantJurisdiction.toBuilder();
			return this;
		}
		
		@Override
		public EquityUnderlyerProvisionsModel build() {
			return new EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelImpl(this);
		}
		
		@Override
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder prune() {
			if (indexAnnexFallbackModel!=null && !indexAnnexFallbackModel.prune().hasData()) indexAnnexFallbackModel = null;
			if (localJurisdiction!=null && !localJurisdiction.prune().hasData()) localJurisdiction = null;
			if (relevantJurisdiction!=null && !relevantJurisdiction.prune().hasData()) relevantJurisdiction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndexAnnexFallbackModel()!=null && getIndexAnnexFallbackModel().hasData()) return true;
			if (getLocalJurisdiction()!=null && getLocalJurisdiction().hasData()) return true;
			if (getRelevantJurisdiction()!=null && getRelevantJurisdiction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder o = (EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder) other;
			
			merger.mergeRosetta(getIndexAnnexFallbackModel(), o.getIndexAnnexFallbackModel(), this::setIndexAnnexFallbackModel);
			merger.mergeRosetta(getLocalJurisdiction(), o.getLocalJurisdiction(), this::setLocalJurisdiction);
			merger.mergeRosetta(getRelevantJurisdiction(), o.getRelevantJurisdiction(), this::setRelevantJurisdiction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityUnderlyerProvisionsModel _that = getType().cast(o);
		
			if (!Objects.equals(indexAnnexFallbackModel, _that.getIndexAnnexFallbackModel())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(relevantJurisdiction, _that.getRelevantJurisdiction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexAnnexFallbackModel != null ? indexAnnexFallbackModel.hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (relevantJurisdiction != null ? relevantJurisdiction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityUnderlyerProvisionsModelBuilder {" +
				"indexAnnexFallbackModel=" + this.indexAnnexFallbackModel + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"relevantJurisdiction=" + this.relevantJurisdiction +
			'}';
		}
	}
}
