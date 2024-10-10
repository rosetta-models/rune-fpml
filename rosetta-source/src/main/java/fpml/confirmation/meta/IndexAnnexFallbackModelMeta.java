package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexAnnexFallbackModel;
import fpml.confirmation.validation.IndexAnnexFallbackModelTypeFormatValidator;
import fpml.confirmation.validation.IndexAnnexFallbackModelValidator;
import fpml.confirmation.validation.exists.IndexAnnexFallbackModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IndexAnnexFallbackModel.class)
public class IndexAnnexFallbackModelMeta implements RosettaMetaData<IndexAnnexFallbackModel> {

	@Override
	public List<Validator<? super IndexAnnexFallbackModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.IndexAnnexFallbackModel>create(fpml.confirmation.validation.datarule.IndexAnnexFallbackModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super IndexAnnexFallbackModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexAnnexFallbackModel> validator() {
		return new IndexAnnexFallbackModelValidator();
	}

	@Override
	public Validator<? super IndexAnnexFallbackModel> typeFormatValidator() {
		return new IndexAnnexFallbackModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexAnnexFallbackModel, Set<String>> onlyExistsValidator() {
		return new IndexAnnexFallbackModelOnlyExistsValidator();
	}
}
