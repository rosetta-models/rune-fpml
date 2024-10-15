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
import fpml.confirmation.CommodityHub;
import fpml.confirmation.CommodityHub.CommodityHubBuilder;
import fpml.confirmation.CommodityHub.CommodityHubBuilderImpl;
import fpml.confirmation.CommodityHub.CommodityHubImpl;
import fpml.confirmation.CommodityHubCode;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.meta.CommodityHubMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a hub or other reference for a physically settled commodity trade.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityHub", builder=CommodityHub.CommodityHubBuilderImpl.class, version="${project.version}")
public interface CommodityHub extends RosettaModelObject {

	CommodityHubMeta metaData = new CommodityHubMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	CommodityHubCode getHubCode();

	/*********************** Build Methods  ***********************/
	CommodityHub build();
	
	CommodityHub.CommodityHubBuilder toBuilder();
	
	static CommodityHub.CommodityHubBuilder builder() {
		return new CommodityHub.CommodityHubBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityHub> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityHub> getType() {
		return CommodityHub.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("hubCode"), processor, CommodityHubCode.class, getHubCode());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityHubBuilder extends CommodityHub, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		CommodityHubCode.CommodityHubCodeBuilder getOrCreateHubCode();
		CommodityHubCode.CommodityHubCodeBuilder getHubCode();
		CommodityHub.CommodityHubBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		CommodityHub.CommodityHubBuilder setHubCode(CommodityHubCode hubCode);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("hubCode"), processor, CommodityHubCode.CommodityHubCodeBuilder.class, getHubCode());
		}
		

		CommodityHub.CommodityHubBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityHub  ***********************/
	class CommodityHubImpl implements CommodityHub {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final CommodityHubCode hubCode;
		
		protected CommodityHubImpl(CommodityHub.CommodityHubBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.hubCode = ofNullable(builder.getHubCode()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("hubCode")
		public CommodityHubCode getHubCode() {
			return hubCode;
		}
		
		@Override
		public CommodityHub build() {
			return this;
		}
		
		@Override
		public CommodityHub.CommodityHubBuilder toBuilder() {
			CommodityHub.CommodityHubBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityHub.CommodityHubBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getHubCode()).ifPresent(builder::setHubCode);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityHub _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(hubCode, _that.getHubCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (hubCode != null ? hubCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityHub {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"hubCode=" + this.hubCode +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityHub  ***********************/
	class CommodityHubBuilderImpl implements CommodityHub.CommodityHubBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected CommodityHubCode.CommodityHubCodeBuilder hubCode;
	
		public CommodityHubBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel() {
			PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder result;
			if (partyAndAccountReferencesModel!=null) {
				result = partyAndAccountReferencesModel;
			}
			else {
				result = partyAndAccountReferencesModel = PartyAndAccountReferencesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("hubCode")
		public CommodityHubCode.CommodityHubCodeBuilder getHubCode() {
			return hubCode;
		}
		
		@Override
		public CommodityHubCode.CommodityHubCodeBuilder getOrCreateHubCode() {
			CommodityHubCode.CommodityHubCodeBuilder result;
			if (hubCode!=null) {
				result = hubCode;
			}
			else {
				result = hubCode = CommodityHubCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public CommodityHub.CommodityHubBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("hubCode")
		public CommodityHub.CommodityHubBuilder setHubCode(CommodityHubCode hubCode) {
			this.hubCode = hubCode==null?null:hubCode.toBuilder();
			return this;
		}
		
		@Override
		public CommodityHub build() {
			return new CommodityHub.CommodityHubImpl(this);
		}
		
		@Override
		public CommodityHub.CommodityHubBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityHub.CommodityHubBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			if (hubCode!=null && !hubCode.prune().hasData()) hubCode = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getHubCode()!=null && getHubCode().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityHub.CommodityHubBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityHub.CommodityHubBuilder o = (CommodityHub.CommodityHubBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getHubCode(), o.getHubCode(), this::setHubCode);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityHub _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(hubCode, _that.getHubCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (hubCode != null ? hubCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityHubBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"hubCode=" + this.hubCode +
			'}';
		}
	}
}
