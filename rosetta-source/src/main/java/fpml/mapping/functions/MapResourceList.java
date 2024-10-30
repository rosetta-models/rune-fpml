package fpml.mapping.functions;

import cdm.legaldocumentation.common.Resource;
import cdm.legaldocumentation.common.Resource.ResourceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapResourceList.MapResourceListDefault.class)
public abstract class MapResourceList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLanguageWithScheme mapLanguageWithScheme;
	@Inject protected MapMimeTypeWithScheme mapMimeTypeWithScheme;
	@Inject protected MapResourceIdWithScheme mapResourceIdWithScheme;
	@Inject protected MapResourceLength mapResourceLength;
	@Inject protected MapResourceTypeWithScheme mapResourceTypeWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return resourceList 
	*/
	public List<? extends Resource> evaluate(DataDocument fpmlDataDocument) {
		List<Resource.ResourceBuilder> resourceListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Resource> resourceList;
		if (resourceListBuilder == null) {
			resourceList = null;
		} else {
			resourceList = resourceListBuilder.stream().map(Resource::build).collect(Collectors.toList());
			objectValidator.validate(Resource.class, resourceList);
		}
		
		return resourceList;
	}

	protected abstract List<Resource.ResourceBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapResourceListDefault extends MapResourceList {
		@Override
		protected List<Resource.ResourceBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Resource.ResourceBuilder> resourceList = new ArrayList<>();
			return assignOutput(resourceList, fpmlDataDocument);
		}
		
		protected List<Resource.ResourceBuilder> assignOutput(List<Resource.ResourceBuilder> resourceList, DataDocument fpmlDataDocument) {
			resourceList.addAll(toBuilder(MapperC.<Resource>of(MapperS.of(Resource.builder()
				.setResourceIdValue(mapResourceIdWithScheme.evaluate(fpmlDataDocument))
				.setResourceTypeValue(mapResourceTypeWithScheme.evaluate(fpmlDataDocument))
				.setLanguageValue(mapLanguageWithScheme.evaluate(fpmlDataDocument))
				.setSizeInBytes(null)
				.setLength(mapResourceLength.evaluate(fpmlDataDocument))
				.setMimeTypeValue(mapMimeTypeWithScheme.evaluate(fpmlDataDocument))
				.setName(null)
				.setComments(null)
				.setString(null)
				.setUrl(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(resourceList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
